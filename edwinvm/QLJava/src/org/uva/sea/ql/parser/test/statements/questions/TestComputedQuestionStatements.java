package org.uva.sea.ql.parser.test.statements.questions;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;

public class TestComputedQuestionStatements extends QuestionTypeChecker {
	@Test
	public void testComputedQuestions() throws ParseError {
		// First we need AnswerableQuestions to store the identifiers used in the ComputedQuestions
		isAValidStatement("\"Price the house was sold for:\" sellingPrice: integer");
		isAValidStatement("\"Price the house was bought for:\" privateDebt: integer");
		
		// Check ComputedQuestions based on stored identifiers
		isAValidStatement("\"Did you sell a house in 2010?\" valueResidue = sellingPrice - privateDebt");
		isAValidStatement("\"Your profit percentage: \" percentageResidue = sellingPrice * 100 / privateDebt");
	}
	
	@Test
	public void testComputedQuestionsTypes() throws ParseError {
		isOfTypeNumeric(
			"\"Price the house was sold for:\" sellingPrice: integer" +
			"\"Price the house was bought for:\" privateDebt: integer" + 
			"\"Did you sell a house in 2010?\" valueResidue = sellingPrice - privateDebt"
		);
		
		isOfTypeNumeric(
			"\"Price the house was sold for:\" sellingPrice: integer" + 
			"\"Price the house was bought for:\" privateDebt: integer" + 
			"\"Your profit percentage: \" percentageResidue = sellingPrice * 100 / privateDebt"
		);
		
		isOfTypeString(
			"\"What is your first name?\" firstName: string" +
			"\"What is your last name?\" lastName: string" +
			"\"Full name:\" fullName = firstName + lastName"
		);
	}
}