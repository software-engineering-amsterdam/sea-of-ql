package org.uva.sea.ql.parser.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.operations.*;
import org.uva.sea.ql.parser.antlr.OrExprParser;
import org.uva.sea.ql.parser.antlr.ParserBase;
import org.uva.sea.ql.parser.exceptions.ParseException;

public class OrExprTests {

	private ParserBase parser;
	
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
