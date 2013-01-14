package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.binary.Add;
import org.uva.sea.ql.ast.nodetypes.binary.GT;
import org.uva.sea.ql.ast.nodetypes.binary.LEq;
import org.uva.sea.ql.ast.nodetypes.binary.LT;
import org.uva.sea.ql.ast.nodetypes.binary.Mul;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestBinaryOperatorExpressions extends TestParser {

	@Test
	public void testAdds() throws ParseError {
		assertEquals(Add.class, parseExpression("a + b").getClass());
		assertEquals(Add.class, parseExpression("a + b + c").getClass());
		assertEquals(Add.class, parseExpression("(a + b + c)").getClass());
		assertEquals(Add.class, parseExpression("a + (b + c)").getClass());
		assertEquals(Add.class, parseExpression("(a + b) + c").getClass());
		assertEquals(Add.class, parseExpression("(a + b)").getClass());
		assertEquals(Add.class, parseExpression("a + b * c").getClass());
		assertEquals(Add.class, parseExpression("a * b + c").getClass());
	}

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
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(LT.class,  parseExpression("a < b").getClass());
		assertEquals(LT.class,  parseExpression("a < b + c").getClass());
		assertEquals(LT.class,  parseExpression("a < (b * c)").getClass());
		assertEquals(LT.class,  parseExpression("(a * b) < c").getClass());
		assertEquals(LEq.class, parseExpression("(a <= b)").getClass());
		assertEquals(GT.class,  parseExpression("a + b > c").getClass());
		assertEquals(GT.class,  parseExpression("a > b + c").getClass());
	}
}
