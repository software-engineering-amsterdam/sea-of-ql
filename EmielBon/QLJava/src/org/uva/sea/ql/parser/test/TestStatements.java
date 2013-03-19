package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.parser.jacc.JACCParser;

public class TestStatements {

	private IParse parser;
	
	public TestStatements() {
		this.parser = new JACCParser();
	}
	
	@Test
	public void testQuestions() throws ParseError {
		assertEquals(parser.parse("x : \"abc\" boolean").getClass(), Question.class);
		assertEquals(parser.parse("dasx : \"452abc\" boolean").getClass(), Question.class);
		assertEquals(parser.parse("hasSoldHouse:\"Did you sell a house in 2010?\" boolean").getClass(), Question.class);
		assertEquals(parser.parse("sellingPrice:\"Price the house was sold for:\" integer(1000+10)").getClass(), ComputedQuestion.class);
	}
	
	@Test
	public void testConditionals() throws ParseError {
		assertEquals(parser.parse("if (bla) { x : \"X?\" boolean }").getClass(), IfThen.class);
		assertEquals(parser.parse("if (bla) { x : \"X?\" boolean } else { y : \"Y?\" boolean}").getClass(), IfThenElse.class);
	}
	
	@Test
	public void testForms() throws ParseError {
		assertEquals(parser.parse("form a { hasSoldHouse:\"Did you sell a house in 2010?\" boolean }").getClass(), Form.class);
		assertEquals(parser.parse("form a { hasSoldHouse:\"Did you sell a house in 2010?\" boolean\n hasBoughtHouse: \"Did you by a house in 2010?\" integer }").getClass(), Form.class);
		assertEquals(parser.parse("\n" +
				"form a { \n" +
				"	hasSoldHouse:\"Did you sell a house in 2010?\" boolean\n" +
				"	hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n" +
				"	if (hasSoldHouse) {\n" +
				"		sellingPrice: \"Price the house was sold for:\" integer(1+2)\n" +
				"	}\n" +
				"}").getClass(), Form.class);
	}
	
}
