package org.uva.sea.ql.check.expressions.test;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.test.ExpressionTypeChecker;

public class TestUnaryExpressionTypes extends ExpressionTypeChecker {
	
	@Test
	public void testNegs() throws ParseError {
		isAValidExpression("--3");
	}
	
	@Test
	public void testPoss() throws ParseError {
		isAValidExpression("++3");
	}
	
	@Test
	public void testNots() throws ParseError {
		isAValidExpression("!true");
	}
}