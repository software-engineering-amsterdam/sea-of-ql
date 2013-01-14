package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.unary.Negative;
import org.uva.sea.ql.ast.nodetypes.unary.Not;
import org.uva.sea.ql.ast.nodetypes.unary.Positive;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestUnaryOperatorExpressions extends TestParser {

	@Test
	public void testPositive() throws ParseError {
		
		assertEquals(Positive.class, parseExpression("+1").getClass());
	}
	
	@Test
	public void testNegative() throws ParseError {
		
		assertEquals(Negative.class, parseExpression("-1").getClass());
	}
	
	@Test
	public void testNot() throws ParseError {
		
		assertEquals(Not.class, parseExpression("!5").getClass());
	}
}
