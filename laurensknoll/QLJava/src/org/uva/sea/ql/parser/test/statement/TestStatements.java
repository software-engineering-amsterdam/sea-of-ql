package org.uva.sea.ql.parser.test.statement;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

@RunWith(Parameterized.class)
public class TestStatements {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> parserList = new ArrayList<Object[]>();
		parserList.add(new Object[] { new Parser() });
		return parserList;
	}

	public TestStatements(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testBlockStatements() throws ParseError {
		assertEquals(Block.class, parser.parse("{ }").getClass());
		assertEquals(
				Block.class,
				parser.parse(
						"{ if (a < b) { hasSoldHouse: \"Did you sell a house in 2010\" boolean } }")
						.getClass());
		assertEquals(
				Block.class,
				parser.parse(
						"{ if (a < b) { } hasSoldHouse: \"Did you sell a house in 2010\" boolean }")
						.getClass());

	}

	@Test
	public void testComputedQuestionStatements() throws ParseError {
		final String remainder = "remainder: \"Subtotal:\" money (priceOfHouse - debtOfHouse)";
		assertEquals(ComputedQuestion.class, parser.parse(remainder).getClass());
	}

	@Test
	public void testIfStatements() throws ParseError {
		assertEquals(If.class, parser.parse("if (a < b) { }")
				.getClass());
		assertEquals(If.class, parser.parse("if (a > b || b < c) { }")
				.getClass());
	}

	@Test
	public void testQuestionStatements() throws ParseError {
		final String hasSoldHouse = "hasSoldHouse: \"Did you sell a house in 2010\" boolean";
		assertEquals(Question.class, parser.parse(hasSoldHouse).getClass());

		final String hasBoughtHouse = "hasBoughtHouse: \"Did you by a house in 2010?\" boolean";
		assertEquals(Question.class, parser.parse(hasBoughtHouse).getClass());

		final String hasMaintLoan = "hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean";
		assertEquals(Question.class, parser.parse(hasMaintLoan).getClass());

		final String priceOfHouse = "priceOfHouse: \"What is the price of your house?\" money";
		assertEquals(Question.class, parser.parse(priceOfHouse).getClass());
	}
}
