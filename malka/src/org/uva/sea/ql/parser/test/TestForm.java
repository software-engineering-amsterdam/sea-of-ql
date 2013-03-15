package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.FormText;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestForm {
	private IParse parser;
	
	public TestForm() {
		this.parser = new ANTLRParser();
	}
	
	@Test
	public void testFormElements() throws ParseError {
		assertEquals(parser.parseFormElement("hasSoldHouse: \"Did you sell a house in 2010?\" boolean").getClass(), Question.class);
		assertEquals(parser.parseFormElement("hasBoughtHouse: \"Did you by a house in 2010?\" boolean").getClass(), Question.class);
		assertEquals(parser.parseFormElement("hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean").getClass(), Question.class);
		assertEquals(parser.parseFormElement("hasSoldHouse: \"Did you sell a house in 2010?\" boolean(blabla-haishgdiasd)").getClass(), FormText.class);
		
		assertEquals(parser.parseFormElements("hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n hasBoughtHouse: \"Did you by a house in 2010?\" boolean \n hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean").getClass(), ArrayList.class);
		List<FormElement> elements = parser.parseFormElements("hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n hasBoughtHouse: \"Did you by a house in 2010?\" boolean \n hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean");
		assertEquals(elements.size(), 3);
		assertTrue(parser.getErrors().isEmpty());
	}
	
	@Test
	public void testForm() throws ParseError {
		Form form = null;
		
		form = parser.parseForm("form Box1HouseOwning { \n hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean \n}");
		assertEquals(form.getClass(), Form.class);
		assertTrue(parser.getErrors().isEmpty());
		
		form = parser.parseForm("form Box1HouseOwning { \n hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean \n if (hasSoldHouse) {\n sellingPrice: \"Price the house was sold for:\" integer\n privateDebt: \"Private debts for the sold house:\" integer\n valueResidue: \"Value residue:\" integer (sellingPrice - privateDebt)\n} }");
		assertEquals(form.getClass(), Form.class);
		assertTrue(parser.getErrors().isEmpty());
	}
}
