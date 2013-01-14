package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.primary.Bool;
import org.uva.sea.ql.ast.nodetypes.primary.Ident;
import org.uva.sea.ql.ast.nodetypes.primary.Int;
import org.uva.sea.ql.ast.nodetypes.primary.Str;
import org.uva.sea.ql.ast.nodetypes.primary.ValuedPrimaryExpression;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestPrimaryExpressions extends TestExpressions {

	@Test
	public void testIds() throws ParseError {
		
		assertEquals(Ident.class, parse("a").getClass());
		assertEquals(Ident.class, parse("abc").getClass());
		assertEquals(Ident.class, parse("ABC").getClass());
		assertEquals(Ident.class, parse("ABCDEF").getClass());
		assertEquals(Ident.class, parse("abc2323").getClass());
		assertEquals(Ident.class, parse("a2bc232").getClass());
		assertEquals(Ident.class, parse("a2bc232aa").getClass());
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(Int.class, parse("0").getClass());
		assertEquals(Int.class, parse("1223").getClass());
		assertEquals(Int.class, parse("234234234").getClass());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testStrings() throws ParseError {
		
		assertEquals(Str.class, parse("\"Test\"").getClass());
		assertEquals("Test", ((ValuedPrimaryExpression<String>) parse("\"Test\"")).getValue());
		assertEquals("\\\"Hello\\\"", ((ValuedPrimaryExpression<String>) parse("\"\\\"Hello\\\"\"")).getValue());
	}
	
	@Test
	public void testBools() throws ParseError {
		
		assertEquals(Bool.class, parse("true").getClass());
		assertEquals(Bool.class, parse("false").getClass());
	}
}
