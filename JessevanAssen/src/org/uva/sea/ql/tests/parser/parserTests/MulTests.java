package org.uva.sea.ql.tests.parser.parserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.parser.ParseError;

import static org.junit.Assert.assertEquals;

public class MulTests extends ParserTests {
	
	@Test
	public void testMuls() throws ParseError {
		assertEquals(Mul.class, parseExpression("a * b").getClass());
		assertEquals(Mul.class, parseExpression("a * b * c").getClass());
		assertEquals(Mul.class, parseExpression("a * (b * c)").getClass());
		assertEquals(Mul.class, parseExpression("(a * b) * c").getClass());
		assertEquals(Mul.class, parseExpression("(a * b)").getClass());
		assertEquals(Mul.class, parseExpression("(a + b) * c").getClass());
		assertEquals(Mul.class, parseExpression("a * (b + c)").getClass());
	}
	
}
