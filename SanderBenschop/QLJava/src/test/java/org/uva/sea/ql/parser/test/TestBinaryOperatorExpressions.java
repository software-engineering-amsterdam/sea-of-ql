package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.binary.Add;
import org.uva.sea.ql.ast.nodetypes.binary.GreaterThan;
import org.uva.sea.ql.ast.nodetypes.binary.LessThan;
import org.uva.sea.ql.ast.nodetypes.binary.LessThanOrEqualTo;
import org.uva.sea.ql.ast.nodetypes.binary.Multiply;
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
		assertEquals(Multiply.class, parseExpression("a * b").getClass());
		assertEquals(Multiply.class, parseExpression("a * b * c").getClass());
		assertEquals(Multiply.class, parseExpression("a * (b * c)").getClass());
		assertEquals(Multiply.class, parseExpression("(a * b) * c").getClass());
		assertEquals(Multiply.class, parseExpression("(a * b)").getClass());
		assertEquals(Multiply.class, parseExpression("(a + b) * c").getClass());
		assertEquals(Multiply.class, parseExpression("a * (b + c)").getClass());
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(LessThan.class,  parseExpression("a < b").getClass());
		assertEquals(LessThan.class,  parseExpression("a < b + c").getClass());
		assertEquals(LessThan.class,  parseExpression("a < (b * c)").getClass());
		assertEquals(LessThan.class,  parseExpression("(a * b) < c").getClass());
		assertEquals(LessThanOrEqualTo.class, parseExpression("(a <= b)").getClass());
		assertEquals(GreaterThan.class,  parseExpression("a + b > c").getClass());
		assertEquals(GreaterThan.class,  parseExpression("a > b + c").getClass());
	}
}
