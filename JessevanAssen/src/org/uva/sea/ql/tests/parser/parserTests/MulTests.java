package org.uva.sea.ql.tests.parser.parserTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.parser.ParseError;

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
