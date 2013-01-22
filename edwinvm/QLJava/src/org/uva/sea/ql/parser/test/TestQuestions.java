package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.ComputedQuestion;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParserQuestions;

public class TestQuestions {
	private IParser _parser;
	
	public TestQuestions() {
		_parser = new ANTLRParserQuestions();
	}
	
	@Test
	public void testQuestions() throws ParseError {
		assertEquals(_parser.parse("\"Did you sell a house in 2010?\" hasSoldHouse: boolean").getClass(), Question.class);
		assertEquals(_parser.parse("\"Price the house was sold for:\" sellingPrice: integer").getClass(), Question.class);
		assertEquals(_parser.parse("\"What is your name?\" userName: string").getClass(), Question.class);
	}
	
	@Test
	public void testComputedQuestions() throws ParseError {
		assertEquals(_parser.parse("\"Did you sell a house in 2010?\" valueResidue = sellingPrice - privateDebt").getClass(), ComputedQuestion.class);
		assertEquals(_parser.parse("\"Your profit percentage: \" percentageResidue = sellingPrice * 100 / privateDebt").getClass(), ComputedQuestion.class);
		assertEquals(_parser.parse("\"Full name:\" fullName = firstName + lastName").getClass(), ComputedQuestion.class);
	}
}