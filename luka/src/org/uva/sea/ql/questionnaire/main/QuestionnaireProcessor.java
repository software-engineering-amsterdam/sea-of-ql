package org.uva.sea.ql.questionnaire.main;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.error.ErrorMessage;
import org.uva.sea.ql.parser.antlr.ParserProcessor;
import org.uva.sea.ql.questionnaire.Questionnaire;
import org.uva.sea.ql.questionnaire.State;
import org.uva.sea.ql.questionnaire.check.QuestionnaireValidator;
import org.uva.sea.ql.questionnaire.ui.swing.QuestionnaireGui;

public class QuestionnaireProcessor {

	private final String qlLocation = "/Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/questionnaireTemplate/something.txt";
	private final String fileLocation = "/Users/luc0/Desktop/test.xml";

	//main class which handles constructing checking and contruction of gui
	public static void main(String[] arg) {
		QuestionnaireProcessor processor = new QuestionnaireProcessor();
		processor.process();
	}

	public void process() {
		State state = new State();

		// Parse Questionnaire
		Questionnaire questionnaire = parseQuestionnaire();
		List<ErrorMessage> errorList = new ArrayList<ErrorMessage>();
		boolean validatoinSuccessfull = validateQuestionnaire(questionnaire,
				errorList);

		// Load GUI
		if (validatoinSuccessfull) {
			System.out.println("Starting GUI");
			initGui(questionnaire, state, fileLocation);
		} else {
			System.err.println("Please first remove the given errors...");
		}

	}

	private Questionnaire parseQuestionnaire() {
		ParserProcessor parser = new ParserProcessor();
		Questionnaire questionnaire = parser.parse(qlLocation, false);
		return questionnaire;
	}

	private boolean validateQuestionnaire(Questionnaire questionnaire,
			List<ErrorMessage> errorList) {
		return QuestionnaireValidator.validateQuestionnaire(
				questionnaire.getName(), questionnaire.getBlock(), errorList);
	}

	private void initGui(final Questionnaire questionnaire, final State state,
			final String fileSaveLocation) {
		QuestionnaireGui.showGui(questionnaire, state, fileSaveLocation);
	}

}
