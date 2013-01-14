package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.primary.Bool;
import org.uva.sea.ql.ast.nodetypes.primary.Ident;
import org.uva.sea.ql.ast.nodetypes.primary.Int;
import org.uva.sea.ql.ast.nodetypes.primary.Str;
import org.uva.sea.ql.ast.nodetypes.primary.ValuedPrimaryExpression;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestPrimaryExpressions extends TestParser {

	@Test
	public void testIds() throws ParseError {
		
		assertEquals(Ident.class, parseExpression("a").getClass());
		assertEquals(Ident.class, parseExpression("abc").getClass());
		assertEquals(Ident.class, parseExpression("ABC").getClass());
		assertEquals(Ident.class, parseExpression("ABCDEF").getClass());
		assertEquals(Ident.class, parseExpression("abc2323").getClass());
		assertEquals(Ident.class, parseExpression("a2bc232").getClass());
		assertEquals(Ident.class, parseExpression("a2bc232aa").getClass());
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(Int.class, parseExpression("0").getClass());
		assertEquals(Int.class, parseExpression("1223").getClass());
		assertEquals(Int.class, parseExpression("234234234").getClass());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testStrings() throws ParseError {
		
		assertEquals(Str.class, parseExpression("\"Test\"").getClass());
		assertEquals("Test", ((ValuedPrimaryExpression<String>) parseExpression("\"Test\"")).getValue());
		assertEquals("\\\"Hello\\\"", ((ValuedPrimaryExpression<String>) parseExpression("\"\\\"Hello\\\"\"")).getValue());
	}
	
	@Test
	public void testBools() throws ParseError {
		
		assertEquals(Bool.class, parseExpression("true").getClass());
		assertEquals(Bool.class, parseExpression("false").getClass());
	}
}
