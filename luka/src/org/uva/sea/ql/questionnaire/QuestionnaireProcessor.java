package org.uva.sea.ql.questionnaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.error.ErrorMessage;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.parser.antlr.ParserProcessor;
import org.uva.sea.ql.questionnaire.check.QuestionnaireValidator;
import org.uva.sea.ql.questionnaire.state.State;
import org.uva.sea.ql.questionnaire.ui.swing.QuestionnaireGui;

public class QuestionnaireProcessor {

	private final String qlLocation = "/Users/luc0/Desktop/Software_Creation/git/sea-of-ql/luka/src/org/uva/sea/ql/parser/antlr/questionnaireTemplate/something.txt";
	private final String fileLocation = "/Users/luc0/Desktop/test.xml";

	public static void main(String[] arg) {
		QuestionnaireProcessor processor = new QuestionnaireProcessor();
		processor.process();
	}

	public void process() {
		State state = new State();

		// Parse Questionnaire

		Questionnaire questionnaire = parseQuestionnaire();
		Map<Ident, Type> typeEnv = questionnaire.getTypeEnv();
		// Validate Questionnaire
		List<ErrorMessage> errorList = new ArrayList<ErrorMessage>();
		boolean validatoinSuccessfull = validateQuestionnaire(questionnaire,
				typeEnv, errorList);

		// Load GUI
		if (validatoinSuccessfull) {
			initGui(questionnaire, state, fileLocation);
		} else {
			System.err.println("Please first remove the given errors...");
		}

	}

	private Questionnaire parseQuestionnaire() {
		ParserProcessor parser = new ParserProcessor();
		Questionnaire questionnaire = parser.parse(qlLocation, false);
		questionnaire.setTypeEnv(parser.getTypeEnv());
		return questionnaire;
	}

	private boolean validateQuestionnaire(Questionnaire questionnaire,
			Map<Ident, Type> typeEnv, List<ErrorMessage> errorList) {
		return QuestionnaireValidator.validateQuestionnaire(
				questionnaire.getName(), questionnaire.getBlock(), typeEnv,
				errorList);
	}

	private void initGui(final Questionnaire questionnaire, final State state,
			final String fileSaveLocation) {
		QuestionnaireGui.showGui(questionnaire, state, fileSaveLocation);
	}

}
