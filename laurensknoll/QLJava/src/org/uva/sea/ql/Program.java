package org.uva.sea.ql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;

import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.parser.test.form.Parser;

public class Program {
	private final static int FormLocation = 0;

	public static void main(String[] args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("Example use: Program form.ql");
		}

		String formText = Program
				.readResourceContent(args[Program.FormLocation]);

		Question questionForm = null;

		try {
			Parser formParser = new Parser();
			questionForm = formParser.parseQuestionForm(formText);
		} catch (ParseError e) {
			System.out.println("Parsing has failed:");
			e.printStackTrace();
			return;
		}

		org.uva.sea.ql.visitor.semantic.Form semanticFormVistor = new org.uva.sea.ql.visitor.semantic.Form();
		Boolean isFormValid = questionForm.accept(semanticFormVistor);
		if (!isFormValid) {
			System.out.println("Form is invalid:");
			for (String error : semanticFormVistor.getErrors()) {
				System.out.println(error);
			}
		} else {
			org.uva.sea.ql.visitor.eval.Form swingVisitor = new org.uva.sea.ql.visitor.eval.Form();
			JFrame frame = questionForm.accept(swingVisitor);
			frame.setVisible(true);
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
