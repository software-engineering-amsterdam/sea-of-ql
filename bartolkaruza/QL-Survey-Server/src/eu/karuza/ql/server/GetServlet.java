package eu.karuza.ql.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.karuza.ql.ast.Form;
import eu.karuza.ql.error.ParseError;
import eu.karuza.ql.error.QLError;
import eu.karuza.ql.parser.IParse;
import eu.karuza.ql.parser.ParserContext;
import eu.karuza.ql.parser.antlr.ANTLRParser;
import eu.karuza.ql.visitor.impl.StatementSemanticChecker;

@SuppressWarnings("serial")
public class GetServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		InputStream stream = getServletContext().getResourceAsStream("/WEB-INF/QL");
		String formString = readForm(stream);
		ParserContext context = parseForm(formString.toString());
		reportErrors(context);
		resp.setContentType(Constants.CONTENT_TYPE_PLAIN + Constants.ENCODING);
		resp.setContentLength(formString.getBytes(Constants.ENCODING).length);
		resp.getWriter().write(formString.toString());
	}
	
	private String readForm(InputStream stream) throws IOException {
		InputStreamReader reader = new InputStreamReader(stream, Constants.ENCODING);
		char[] buffer = new char[1];
		StringBuilder builder = new StringBuilder(1);
		while (reader.read(buffer) != -1) {
			builder.append(buffer);
			builder.trimToSize();
		}
		return builder.toString();
	}

	private ParserContext parseForm(String formString) {
		ParserContext context = new ParserContext();
		IParse parser = new ANTLRParser();
		Form form;
		try {
			form = (Form) parser.parseNode(formString);
		} catch(ParseError pe) {
			context.addError(new QLError(pe.getLocalizedMessage()));
			return context;
		}
		context.setForm(form);
		return checkForm(context);
	}
	
	private ParserContext checkForm(ParserContext context) {	
		StatementSemanticChecker statementChecker = new StatementSemanticChecker(context);
		Form form = context.getForm();
		form.accept(statementChecker);
		return context;
	}

	private void reportErrors(ParserContext context) {
		for(QLError error : context.getErrors()) {
			System.out.println("Error found: " + error.getCause());
		}
	}
}
