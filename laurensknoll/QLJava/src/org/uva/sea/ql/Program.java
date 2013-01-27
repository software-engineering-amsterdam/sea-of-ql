package org.uva.sea.ql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.parser.test.form.Parser;

public class Program {

	public static void main(String[] args) {
		String formText = Program.readResourceContent("questionForm.txt");

		Question questionForm = null;

		try {
			Parser formParser = new Parser();
			questionForm = formParser.parseQuestionForm(formText);
		} catch (ParseError e) {
			// TODO Create meaningful error messages during parsing.
			e.printStackTrace();
		}

		org.uva.sea.ql.visitor.semantic.Form semanticFormVistor = new org.uva.sea.ql.visitor.semantic.Form();
		Boolean isFormValid = questionForm.accept(semanticFormVistor);
		if (!isFormValid) {
			for (String error : semanticFormVistor.getErrors()) {
				System.out.println(error);
			}
		} else {
			org.uva.sea.ql.visitor.print.Form printFormVisitor = new org.uva.sea.ql.visitor.print.Form();
			String prettyForm = questionForm.accept(printFormVisitor);
			System.out.print(prettyForm);
		}
	}

	private static String readResourceContent(String location) {
		Program program = new Program();
		InputStream inputStream = program.getClass().getResourceAsStream(
				location);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		StringBuilder sb = new StringBuilder();

		try {
			while (bufferedReader.ready()) {
				sb.append(bufferedReader.readLine());
			}
		} catch (IOException ex) {
			String exceptionMessage = String.format(
					"IOException while reading resource {0}: {1}", location,
					ex.getMessage());
			System.out.println(exceptionMessage);
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// Ignore. Resource is closed already.
				}
			}
		}

		return sb.toString();
	}
}
