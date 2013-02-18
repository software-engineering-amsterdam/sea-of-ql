package org.uva.sea.ql.parser.test.statements;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;

public class TestQuestionStatements extends StatementTypeChecker {
	@Test
	public void testQuestions() throws ParseError {
		isAValidStatement("\"Did you sell a house in 2010?\" hasSoldHouse: boolean");
		isAValidStatement("\"Price the house was sold for:\" sellingPrice: integer");
		isAValidStatement("\"What is your name?\" userName: string");
	}
	
	@Test
	public void testComputedQuestions() throws ParseError {
		isAValidStatement("\"Did you sell a house in 2010?\" valueResidue = sellingPrice - privateDebt");
		isAValidStatement("\"Your profit percentage: \" percentageResidue = sellingPrice * 100 / privateDebt");
		isAValidStatement("\"Full name:\" fullName = firstName + lastName");
	}
}