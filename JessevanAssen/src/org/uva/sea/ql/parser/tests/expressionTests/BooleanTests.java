package org.uva.sea.ql.parser.tests.expressionTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.ParseError;


public class BooleanTests extends ExpressionTests {

	@Test
	public void testParseTrue() throws ParseError {
		ASTNode parsed = parser.parse("true");
		assertEquals(Bool.class, parsed.getClass());
		
		assertTrue(((Bool) parsed).getValue());
	}
	
	@Test
	public void testParseFalse() throws ParseError {
		ASTNode parsed = parser.parse("false");
		assertEquals(Bool.class, parsed.getClass());
		
		assertFalse(((Bool) parsed).getValue());
	}
	
}
