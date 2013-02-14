package org.uva.sea.ql.check.expressions.test;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;

public class TestBinaryLogicalExpressionTypes extends ExpressionTypeChecker {
	
	@Test
	public void testAnds() throws ParseError {
		isAValidExpression("true && true");
		isAValidExpression("true && false");
		isAValidExpression("false && false");
		
		isAValidExpression("true && 1 <= 2");
		
		isNotAValidExpression("1 && 1");
		isNotAValidExpression("1 && true");
		isNotAValidExpression("false && a");
	}
	
	@Test
	public void testOrs() throws ParseError {
		isAValidExpression("true || true");
		isAValidExpression("true || false");
		isAValidExpression("false || false");
		
		isAValidExpression("true || 1 <= 2");
		
		isNotAValidExpression("1 || 1");
		isNotAValidExpression("1 || true");
		isNotAValidExpression("false || a");
	}
}