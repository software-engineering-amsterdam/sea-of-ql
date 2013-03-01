package org.uva.sea.ql.test.types;

import org.junit.Test;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestLogicalExpressionTypes extends ExpressionTypeChecker {
	@Test
	public void testLogicallyEquivalentExpressionTypes() throws ParseError {
		isAValidExpression("true && true");
		isAValidExpression("true && false");
		isAValidExpression("false && false");
		
		isAValidExpression("true && 1 <= 2");
		
		isNotAValidExpression("1 && 1");
		isNotAValidExpression("1 && true");
		isNotAValidExpression("false && a");
	}
	
	@Test
	public void testLogicallyEquivalentOrNotExpressionTypes() throws ParseError {
		isAValidExpression("true || true");
		isAValidExpression("true || false");
		isAValidExpression("false || false");
		
		isAValidExpression("true || 1 <= 2");
		
		isNotAValidExpression("1 || 1");
		isNotAValidExpression("1 || true");
		isNotAValidExpression("false || a");
	}
	
	@Test
	public void testNegations() throws ParseError {
		isAValidExpression("!true");
		isAValidExpression("!false");
	}
}