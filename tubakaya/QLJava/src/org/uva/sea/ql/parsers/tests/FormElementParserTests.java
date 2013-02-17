package org.uva.sea.ql.parsers.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.core.dom.statements.FormElement;
import org.uva.sea.ql.parsers.FormElementParser;
import org.uva.sea.ql.parsers.ParserBaseForStatements;
import org.uva.sea.ql.parsers.exceptions.ParseException;

public class FormElementParserTests {

	private ParserBaseForStatements parser;
	
	@Before
    public void setUp() {
		this.parser = new FormElementParser();
    }
	
	@Test
	public void does_returnFormElementExpression_when_typeIsBoolean() throws ParseException {
		assertEquals(FormElement.class, parser.parse("hasSoldHouse: \"Did you sell a house in 2010?\" boolean").getClass());		
	}
	
	@Test
	public void does_returnFormElementExpression_when_typeIsInt() throws ParseException {
		assertEquals(FormElement.class, parser.parse("hasSoldHouse: \"Did you sell a house in 2010?\" int").getClass());	
	}
	
	@Test
	public void does_returnFormElementExpression_when_typeIsString() throws ParseException {
		assertEquals(FormElement.class, parser.parse("hasSoldHouse: \"Did you sell a house in 2010?\" string").getClass());	
	}
}
