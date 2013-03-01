package org.uva.sea.ql.test.types;

import org.junit.Test;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestLogicalExpressionTypes extends ExpressionTypeChecker {
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
	
	@Test
	public void testNots() throws ParseError {
		isAValidExpression("!true");
		isAValidExpression("!false");
	}
}