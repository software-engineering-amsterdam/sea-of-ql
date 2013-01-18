package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.antlr.StatementParser;

@RunWith(Parameterized.class)
public class TestStatements {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> parserList = new ArrayList<Object[]>();
		parserList.add(new Object[] {new StatementParser()});
		return parserList;
	}

	public TestStatements(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testIfStatements() throws ParseError {
		final String questionString = "hasSoldHouse: \"Did you sell a house?\" money";
		
		assertEquals(parser.parse("if (a < b) " + questionString).getClass(), IfStatement.class);
		assertEquals(parser.parse("if (a > b || b < c) " + questionString).getClass(), IfStatement.class);
	}

	@Test
	public void testQuestionStatements() throws ParseError {
		/*assertEquals(parser.parse("hasSoldHouse: \"Did you sell a house in 2010\" boolean").getClass(), Question.class);
		assertEquals(parser.parse("hasBoughtHouse: \"Did you by a house in 2010?\" boolean").getClass(), Question.class);
		assertEquals(parser.parse("hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean").getClass(), Question.class);
		
		assertEquals(parser.parse("priceOfHouse: \"What is the price of your house?\" money").getClass(), Question.class);
		*/
		
		ASTNode parseValue = parser.parse("remainder: \"Subtotal:\" money (priceOfHouse - debtOfHouse)");
		assertEquals(parseValue.getClass(), Summary.class);
	}
}
