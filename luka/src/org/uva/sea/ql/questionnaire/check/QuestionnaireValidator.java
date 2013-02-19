package org.uva.sea.ql.questionnaire.check;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.error.ErrorMessage;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.stat.Block;
import org.uva.sea.ql.ast.type.Type;

public class QuestionnaireValidator {

	public static boolean validateQuestionnaire(String questionnaireName,
			Block qBlock, List<ErrorMessage> errorList) {
		Map<Ident, Type> typeEnv = new HashMap<Ident, Type>();

		System.out.println("Checking Questionnaire: " + questionnaireName);

		CheckStat.checkStatBlock(qBlock, typeEnv, errorList);

		if (errorList.isEmpty()) {
			System.out.println("No errors occured!");
			return true;
		}
		printErrorList(errorList);
		return false;
	}

	private static void printErrorList(List<ErrorMessage> errorList) {
		System.err.println("-----Errors occured-----");
		for (ErrorMessage error : errorList) {
			System.err.println(error.getErrorMeesage());
		}
	}
}
