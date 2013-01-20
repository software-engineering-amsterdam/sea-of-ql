package org.uva.sea.ql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.uva.sea.ql.ast.form.QuestionForm;
import org.uva.sea.ql.parser.antlr.FormParser;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.visitor.print.PrintFormVisitor;

public class Program {

	public static void main(String[] args) {
		String formText = Program.readResourceContent("questionForm.txt");

		QuestionForm questionForm = null;

		try {
			FormParser formParser = new FormParser();
			questionForm = formParser.parseQuestionForm(formText);
		} catch (ParseError e) {
			// TODO Create meaningful error messages during parsing.
			e.printStackTrace();
		}

		PrintFormVisitor printFormVisitor = new PrintFormVisitor();
		questionForm.accept(printFormVisitor);
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
