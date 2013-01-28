package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserForms;

public class TestForms {
	private IParser _parser;
	
	public TestForms() {
		_parser = new ANTLRParserForms();
	}
	
	@Test
	public void testFormSingleQuestion() throws ParseError {
		assertEquals(_parser.parse("form boxHouse1Owning { \"Did you sell a house in 2010?\" hasSoldHouse: boolean }").getClass(), Form.class);
	}
	
	@Test
	public void testFormMultipleQuestions() throws ParseError {
		assertEquals(_parser.parse("form boxHouse1Owning { \"Did you sell a house in 2010?\" hasSoldHouse: boolean \"Price the house was sold for:\" sellingPrice: integer }").getClass(), Form.class);
	}
	
	@Test
	public void testFormWithIfStatement() throws ParseError {
		assertEquals(_parser.parse("form boxHouse1Owning { \"Did you sell a house in 2010?\" hasSoldHouse: boolean if (hasSoldHouse) { \"Qualifies for loan:\" qualifiesForLoan = \"true\" } }").getClass(), Form.class);
	}
}