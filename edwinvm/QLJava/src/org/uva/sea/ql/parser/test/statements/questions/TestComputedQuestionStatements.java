package org.uva.sea.ql.parser.test.statements.questions;

import org.junit.Test;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestComputedQuestionStatements extends ComputedQuestionTypeChecker {
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
		// First we need AnswerableQuestions to store the identifiers used in the ComputedQuestions
		isAValidStatement("\"Price the house was sold for:\" sellingPrice: integer");
		isAValidStatement("\"Price the house was bought for:\" privateDebt: integer");
		isOfComputedTypeNumeric("\"Did you sell a house in 2010?\" valueResidue = sellingPrice - privateDebt");
		isOfComputedTypeNumeric("\"Your profit percentage: \" percentageResidue = sellingPrice * 100 / privateDebt");
		
		// First we need AnswerableQuestions to store the identifiers used in the ComputedQuestion
		isAValidStatement("\"Do you want to buy a house in 2013?\" wantsToBuyHouse: boolean");
		isAValidStatement("\"Do you want to buy a car in 2013?\" wantsToBuyCar: boolean");
		isOfComputedTypeBoolean("\"Qualifies for large insurance:\" insuranceProspect = wantsToBuyHouse && wantsToBuyCar");
	}
}