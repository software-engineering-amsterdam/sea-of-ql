package org.uva.sea.ql.parsers.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.core.dom.operators.conditional.*;
import org.uva.sea.ql.parsers.OrExprParser;
import org.uva.sea.ql.parsers.ParserBaseForExpressions;
import org.uva.sea.ql.parsers.exceptions.ParseException;

public class OrExprParserTests {

	private ParserBaseForExpressions parser;
	
	@Before
    public void setUp() {
		this.parser = new OrExprParser();
    }
	
	@Test
	public void does_returnOrExpression_when_orCharacterUsedBetweenTwoIdentifiers() throws ParseException {
		assertEquals(parser.parse("a || b").getClass(), Or.class);		
	}
	
	@Test
	public void does_returnOrExpression_when_orCharactersUsedBetweenThreeIdentifiers() throws ParseException {
		assertEquals(parser.parse("a || b || c").getClass(), Or.class);		
	}
	
	@Test
	public void does_returnOrExpression_when_orCharacterUsedTogetherWithAndExpression() throws ParseException {
		assertEquals(parser.parse("a || b && c").getClass(), Or.class);		
	}
}
