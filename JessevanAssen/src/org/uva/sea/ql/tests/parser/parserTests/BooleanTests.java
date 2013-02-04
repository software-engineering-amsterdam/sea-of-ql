package org.uva.sea.ql.tests.parser.parserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.parser.ParseError;

import static org.junit.Assert.*;


public class BooleanTests extends ParserTests {

	@Test
	public void testParseTrue() throws ParseError {
		Expr parsed = parseExpression("true");
		assertEquals(Bool.class, parsed.getClass());
		
		assertTrue(((Bool) parsed).getValue());
	}
	
	@Test
	public void testParseFalse() throws ParseError {
		Expr parsed = parseExpression("false");
		assertEquals(Bool.class, parsed.getClass());
		
		assertFalse(((Bool) parsed).getValue());
	}
	
}
