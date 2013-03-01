package org.uva.sea.ql.test.types;

import org.junit.Test;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestArithmeticalExpressionTypes extends ExpressionTypeChecker {
	@Test
	public void testAdds() throws ParseError {
		isAValidExpression("1 + 1");
		isAValidExpression("1 + 1");
		isAValidExpression("1 + (2 + 3)");
		isAValidExpression("1 + (2 + 3.0)");
		
		isNotAValidExpression("1 + a");
		isNotAValidExpression("1 + true");
		isNotAValidExpression("true + true");
	}
	
	@Test
	public void testMuls() throws ParseError {
		isAValidExpression("1 * 1");
		isAValidExpression("1 * (2 * 3)");
		isAValidExpression("1 * (2 * 3.0)");
		
		isNotAValidExpression("1 * a");
		isNotAValidExpression("1 * true");
		isNotAValidExpression("true * true");
	}
	
	@Test
	public void testDivs() throws ParseError {
		isAValidExpression("10 / 2");
		isAValidExpression("10 / (2 * 1)");
		isAValidExpression("10 / (2 * 2.50)");
		
		isNotAValidExpression("1 / a");
		isNotAValidExpression("1 / true");
		isNotAValidExpression("true / true");
	}
	
	@Test
	public void testSubs() throws ParseError {
		isAValidExpression("10 - 10");
		isAValidExpression("10 - (2 * 5)");
		isAValidExpression("10 - (2 * 2.50)");
		
		isNotAValidExpression("1 - a");
		isNotAValidExpression("1 - true");
		isNotAValidExpression("true - true");
	}
	
	// Unary operations
	
	@Test
	public void testNegs() throws ParseError {
		isAValidExpression("-3");
		isAValidExpression("--3");
	}
	
	@Test
	public void testPoss() throws ParseError {
		isAValidExpression("+3");
		isAValidExpression("++3");
	}
}