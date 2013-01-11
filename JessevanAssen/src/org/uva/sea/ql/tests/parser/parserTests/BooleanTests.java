package org.uva.sea.ql.tests.parser.parserTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.Bool;
import org.uva.sea.ql.parser.ParseError;


public class BooleanTests extends ParserTests {

	@Test
	public void testParseTrue() throws ParseError {
		ASTNode parsed = parseExpression("true");
		assertEquals(Bool.class, parsed.getClass());
		
		assertTrue(((Bool) parsed).getValue());
	}
	
	@Test
	public void testParseFalse() throws ParseError {
		ASTNode parsed = parseExpression("false");
		assertEquals(Bool.class, parsed.getClass());
		
		assertFalse(((Bool) parsed).getValue());
	}
	
}
