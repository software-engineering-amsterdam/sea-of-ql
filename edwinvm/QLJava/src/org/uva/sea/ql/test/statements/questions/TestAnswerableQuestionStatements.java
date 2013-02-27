package org.uva.sea.ql.test.statements.questions;

import org.junit.Test;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestAnswerableQuestionStatements extends QuestionTypeChecker {
	@Test
	public void testQuestions() throws ParseError {
		isAValidStatement("\"Did you sell a house in 2010?\" hasSoldHouse: boolean");
		isAValidStatement("\"Price the house was sold for:\" sellingPrice: integer");
		isAValidStatement("\"What is your name?\" userName: string");
	}
	
	@Test
	public void testQuestionTypes() throws ParseError {
		isOfTypeBoolean("\"Did you sell a house in 2010?\" hasSoldHouse: boolean");
		isOfTypeNumeric("\"Price the house was sold for:\" sellingPrice: money");
		isOfTypeMoney("\"Price the house was sold for:\" sellingPrice: money");
		isOfTypeInt("\"Price the house was sold for:\" sellingPrice: integer");
		isOfTypeString("\"What is your name?\" userName: string");
	}
}