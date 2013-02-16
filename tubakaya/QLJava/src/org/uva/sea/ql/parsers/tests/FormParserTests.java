package org.uva.sea.ql.parsers.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.parsers.FormParser;
import org.uva.sea.ql.parsers.ParserBase;
import org.uva.sea.ql.parsers.exceptions.ParseException;

public class FormParserTests {

	private ParserBase parser;
	
	@Before
    public void setUp() {
		this.parser = new FormParser();
    }
	
	@Test
	public void does_returnFormExpression_when_thereIsOneFormElementInsideForm() throws ParseException {
		
		String text="form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean }";
		assertEquals(Form.class, parser.parse(text).getClass());		
	}
	
}
