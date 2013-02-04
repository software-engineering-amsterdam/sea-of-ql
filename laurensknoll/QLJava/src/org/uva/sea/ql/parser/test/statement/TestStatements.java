package org.uva.sea.ql.parser.test.statement;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.ast.statement.ComputedQuestion;
import org.uva.sea.ql.ast.statement.If;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class TestStatements {

	private IParse parser;

	public TestStatements() {
		this.parser = new Parser();
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
		assertEquals(If.class, parser.parse("if (a < b) { }").getClass());
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
