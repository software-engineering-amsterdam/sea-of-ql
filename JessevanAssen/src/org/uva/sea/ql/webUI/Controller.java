package org.uva.sea.ql.webUI;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.interpreter.InterpreterVisitor;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.Parser;
import org.uva.sea.ql.typechecker.TypecheckerVisitor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Controller extends HttpServlet {

    public static String VIEWMODEL_ATTRIBUTE = "viewModel_attribute";

    private static final String VIEWPATH = "form.jsp";
    private static final String JSON_CONTENTTYPE = "application/json";
    private static final String SAMPLE_FORM =
            "form Box1HouseOwning {" +
                    "    \"Did you sell a house in 2010?\" hasSoldHouse: boolean" +
                    "    \"Did you by a house in 2010?\" hasBoughtHouse: boolean" +
                    "    \"Did you enter a loan for maintenance/reconstruction?\" hasMaintLoan: boolean" +
                    "    if (hasSoldHouse) {" +
                    "        \"Private debts for the sold house:\" privateDebt: integer" +
                    "        \"Price the house was sold for:\" sellingPrice: integer" +
                    "        \"Value residue:\" sellingPrice - privateDebt" +
                    "    }" +
                    "}";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showFormView(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> postValues = flatten(request.getParameterMap());
        Form form = parseForm();
        InterpreterVisitor.Result result = InterpreterVisitor.interpret(form, postValues);

        if(result.getErrors().isEmpty())
            response.setStatus(HttpServletResponse.SC_OK);
        else
            showErrors(result.getErrors().iterator(), response);
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

    private void showFormView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Form parsedForm = parseForm();

        String viewModel = KnockoutJSViewModelBuilderVisitor.createViewModel(parsedForm);
        request.setAttribute(VIEWMODEL_ATTRIBUTE, viewModel);

        RequestDispatcher view = request.getRequestDispatcher(VIEWPATH);
        view.forward(request, response);
    }

    private Form parseForm() {
        try {
            Parser parser = new org.uva.sea.ql.parser.antlr.ANTLRParser();
            Form form = parser.parse(SAMPLE_FORM);

            List<Message> errors = TypecheckerVisitor.typecheck(form);

            if(errors.isEmpty())
                return form;
            else
                throw new RuntimeException(buildMessageString(errors));
        } catch(ParseError parseError) {
            throw new RuntimeException("Parsing the form failed.", parseError);
        }
    }

    private String buildMessageString(Iterable<Message> messages) {
        StringBuilder stringBuilder = new StringBuilder("The following errors occurred while doing a semantic check of the QL form:\n");
        for(Iterator<Message> iterator = messages.iterator(); iterator.hasNext() ; )
            stringBuilder
                    .append(" - ")
                    .append(iterator.next())
                    .append("\n");

        return stringBuilder.toString();
    }

}
