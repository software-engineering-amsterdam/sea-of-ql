package org.uva.sea.ql.gui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.uva.sea.ql.ast.forms.Form;
import org.uva.sea.ql.ast.forms.IncorrectForm;
import org.uva.sea.ql.ast.statements.StatementBody;
import org.uva.sea.ql.check.statements.StatementChecker;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.TypeEnvironment;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserForms;
import org.uva.sea.ql.parser.errors.ErrorMessages;
import org.uva.sea.ql.parser.errors.ParseError;

public class QuestionnaireHandler {
	
	private static StatementChecker _statementChecker;
	private static TypeEnvironment _typeEnvironment;
	private static ErrorMessages _errorMessages;

	private static void initializeQuestionnaireHandler() {
		_typeEnvironment  = new TypeEnvironment();
		_errorMessages    = new ErrorMessages();
		_statementChecker = new StatementChecker(_typeEnvironment, _errorMessages);
	}
	
	public static Form getQuestionnaire() {
		initializeQuestionnaireHandler();
		Form questionnaire = parseForm(); 
		checkStatements(questionnaire.getBody());
		if (!isFormValid()) {
			return IncorrectForm.InvalidQLForm();
		}
		return questionnaire;
	}
	
	private static boolean isFormValid() {
		return !_errorMessages.hasErrors();
	}
	
	private static void checkStatements(StatementBody statementBody) {
		_statementChecker.check(statementBody);
	}
	
	public static TypeEnvironment getTypeEnvironment() {
		return _typeEnvironment;
	}
	
	private static Form parseForm() {
		IParser qlParser = new ANTLRParserForms();
		String input;
		try {
			input = readFileAsString("resources/Questionnaire.ql");
			return (Form) qlParser.parse(input);
		} catch (IOException e) { e.printStackTrace(); } 
		catch (ParseError e) { e.printStackTrace(); }
		return null;
	}
	
	private static String readFileAsString(String filePath) throws IOException {
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] buffer = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buffer)) != -1) {
			String readData = String.valueOf(buffer, 0, numRead);
			fileData.append(readData);
			buffer = new char[1024];
		}
		reader.close();
		return fileData.toString();
	}
}
