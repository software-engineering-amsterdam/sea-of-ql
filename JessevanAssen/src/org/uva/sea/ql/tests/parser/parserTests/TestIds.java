package org.uva.sea.ql.tests.parser.parserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.parser.ParseError;

import static org.junit.Assert.assertEquals;

public class TestIds extends ParserTests {

	@Test
	public void testIds() throws ParseError {
		assertEquals(Identifier.class, parseExpression("a").getClass());
		assertEquals(Identifier.class, parseExpression("abc").getClass());
		assertEquals(Identifier.class, parseExpression("ABC").getClass());
		assertEquals(Identifier.class, parseExpression("ABCDEF").getClass());
		assertEquals(Identifier.class, parseExpression("abc2323").getClass());
		assertEquals(Identifier.class, parseExpression("a2bc232").getClass());
		assertEquals(Identifier.class, parseExpression("a2bc232aa").getClass());
	}
	
}
