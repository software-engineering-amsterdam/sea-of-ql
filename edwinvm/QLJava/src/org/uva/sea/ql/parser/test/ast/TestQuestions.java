package org.uva.sea.ql.parser.test.ast;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserQuestions;
import org.uva.sea.ql.parser.test.StatementParserChecker;

public class TestQuestions extends StatementParserChecker {
	public TestQuestions() {
		super(new ANTLRParserQuestions());
	}
	
	@Test
	public void testQuestions() throws ParseError {
		statementMatchesAnswerableQuestion("\"Did you sell a house in 2010?\" hasSoldHouse: boolean");
		statementMatchesAnswerableQuestion("\"Price the house was sold for:\" sellingPrice: integer");
		statementMatchesAnswerableQuestion("\"What is your name?\" userName: string");
	}
	
	@Test
	public void testComputedQuestions() throws ParseError {
		statementMatchesComputedQuestion("\"Did you sell a house in 2010?\" valueResidue = sellingPrice - privateDebt");
		statementMatchesComputedQuestion("\"Your profit percentage: \" percentageResidue = sellingPrice * 100 / privateDebt");
		statementMatchesComputedQuestion("\"Full name:\" fullName = firstName + lastName");
	}
}