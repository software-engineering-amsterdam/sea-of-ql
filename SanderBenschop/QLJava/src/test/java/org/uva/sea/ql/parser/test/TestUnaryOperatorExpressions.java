package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.unary.Neg;
import org.uva.sea.ql.ast.unary.Not;
import org.uva.sea.ql.ast.unary.Pos;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestUnaryOperatorExpressions extends TestExpressions {

	@Test
	public void testPositive() throws ParseError {
		
		assertEquals(Pos.class, parse("+1").getClass());
	}
	
	@Test
	public void testNegative() throws ParseError {
		
		assertEquals(Neg.class, parse("-1").getClass());
	}
	
	@Test
	public void testNot() throws ParseError {
		
		assertEquals(Not.class, parse("!5").getClass());
	}
}
