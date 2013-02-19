package org.uva.sea.ql.webUI;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.value.Value;
import org.uva.sea.ql.formLoader.FormLoaderFactory;
import org.uva.sea.ql.interpreter.InterpreterVisitor;
import org.uva.sea.ql.valuePersister.ValuePersister;
import org.uva.sea.ql.valuePersister.ValuePersisterFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Controller extends HttpServlet {

    public static final String VIEWMODEL_ATTRIBUTE = "viewModel_attribute";

    private static final String FORMFILE_NAME = "Box1HouseOwning.ql";
    private static final String VIEWPATH = "form.jsp";
    private static final String JSON_CONTENTTYPE = "application/json";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // This could throw an exception if the form isn't in the correct format.
        // However, there is nothing the application can do to repair this, so
        // go for the 'organized panic'-strategy and notify the caller that the
        // form is broken via the default server exception handling mechanism.
        Form form = FormLoaderFactory.createFormLoaderFromFile(getFormFile()).loadForm();
        String viewModel = KnockoutJSViewModelBuilderVisitor.createViewModel(form);
        request.setAttribute(VIEWMODEL_ATTRIBUTE, viewModel);

        RequestDispatcher view = request.getRequestDispatcher(VIEWPATH);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> postValues = flatten(request.getParameterMap());
        Form form = FormLoaderFactory.createFormLoaderFromFile(getFormFile()).loadForm();
        InterpreterVisitor.Result result = InterpreterVisitor.interpret(form, postValues);

        if(result.getErrors().isEmpty()) {
            persistFormValues(result.getIdentifiers());
            response.setStatus(HttpServletResponse.SC_OK);
        } else
            showErrors(result.getErrors().iterator(), response);
    }

    private File getFormFile() {
        String formFilePath = getServletContext().getRealPath(FORMFILE_NAME);
        return new File(formFilePath);
    }

    private void persistFormValues(Map<Identifier, Value> values) {
        ValuePersister persister = ValuePersisterFactory.createValuePersister();
        persister.persist(values);
    }

    private void showErrors(Iterator<Message> errors, HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.setContentType(JSON_CONTENTTYPE);
        PrintWriter responseWriter = response.getWriter();
        responseWriter.append("{\"errors\":[");
        while(errors.hasNext()) {
            responseWriter
                    .append('"')
                    .append(errors.next().toString())
                    .append('"');
            if(errors.hasNext())
                responseWriter.append(",");
        }
        responseWriter.append("]}");
        responseWriter.close();
    }

    private Map<String, String> flatten(Map<String, String[]> input) {
        Map<String, String> postValues = new HashMap<String, String>();
        for(String key : input.keySet())
            postValues.put(key, input.get(key)[0]);
        return postValues;
    }
}
