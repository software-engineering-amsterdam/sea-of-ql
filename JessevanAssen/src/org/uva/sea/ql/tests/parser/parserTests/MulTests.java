package org.uva.sea.ql.tests.parser.parserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Multiply;
import org.uva.sea.ql.parser.ParseError;

import static org.junit.Assert.assertEquals;

public class MulTests extends ParserTests {
	
	@Test
	public void testMuls() throws ParseError {
		assertEquals(Multiply.class, parseExpression("a * b").getClass());
		assertEquals(Multiply.class, parseExpression("a * b * c").getClass());
		assertEquals(Multiply.class, parseExpression("a * (b * c)").getClass());
		assertEquals(Multiply.class, parseExpression("(a * b) * c").getClass());
		assertEquals(Multiply.class, parseExpression("(a * b)").getClass());
		assertEquals(Multiply.class, parseExpression("(a + b) * c").getClass());
		assertEquals(Multiply.class, parseExpression("a * (b + c)").getClass());
	}
	
}
