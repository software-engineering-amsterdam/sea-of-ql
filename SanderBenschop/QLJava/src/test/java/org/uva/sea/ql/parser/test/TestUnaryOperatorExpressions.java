package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.unary.Neg;
import org.uva.sea.ql.ast.nodetypes.unary.Not;
import org.uva.sea.ql.ast.nodetypes.unary.Pos;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestUnaryOperatorExpressions extends TestParser {

	@Test
	public void testPositive() throws ParseError {
		
		assertEquals(Pos.class, parseExpression("+1").getClass());
	}
	
	@Test
	public void testNegative() throws ParseError {
		
		assertEquals(Neg.class, parseExpression("-1").getClass());
	}
	
	@Test
	public void testNot() throws ParseError {
		
		assertEquals(Not.class, parseExpression("!5").getClass());
	}
}
