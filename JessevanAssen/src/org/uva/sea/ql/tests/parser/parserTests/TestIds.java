package org.uva.sea.ql.tests.parser.parserTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.parser.ParseError;

public class TestIds extends ParserTests {

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
	
}
