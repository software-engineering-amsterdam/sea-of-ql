package org.uva.sea.ql.parser.test.statements;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;

public class TestComputedQuestionStatements extends StatementTypeChecker {
	@Test
	public void testComputedQuestions() throws ParseError {
		isAValidStatement(
			"\"Price the house was sold for:\" sellingPrice: integer" +
			"\"Price the house was bought for:\" privateDebt: integer" + 
			"\"Did you sell a house in 2010?\" valueResidue = sellingPrice - privateDebt"
		);
		
		isAValidStatement(
			"\"Price the house was sold for:\" sellingPrice: integer" + 
			"\"Price the house was bought for:\" privateDebt: integer" + 
			"\"Your profit percentage: \" percentageResidue = sellingPrice * 100 / privateDebt"
		);
		
		isAValidStatement(
			"\"What is your first name?\" firstName: string" +
			"\"What is your last name?\" lastName: string" +
			"\"Full name:\" fullName = firstName + lastName"
		);
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