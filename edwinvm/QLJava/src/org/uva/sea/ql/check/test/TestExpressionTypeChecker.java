package org.uva.sea.ql.check.test;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Add;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Div;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Mul;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Sub;
import org.uva.sea.ql.parser.ParseError;

public class TestExpressionTypeChecker extends ExpressionTypeChecker {
	
	@Test
	public void testAdds() throws ParseError {
		isAValidExpression(parseExpression("1 + 1"));
		isAValidExpression(parseExpression("1 + 1"));
		isAValidExpression(parseExpression("1 + (2 + 3)"));
		isAValidExpression(parseExpression("1 + (2 + 3.0)"));
		
		isNotAValidExpression(parseExpression("1 + a"));
		isNotAValidExpression(parseExpression("1 + true"));
		isNotAValidExpression(parseExpression("true + true"));
	}
	
	@Test
	public void testMuls() throws ParseError {
		isAValidExpression(parseExpression("1 * 1"));
		isAValidExpression(parseExpression("1 * (2 * 3)"));
		isAValidExpression(parseExpression("1 * (2 * 3.0)"));
		
		isNotAValidExpression(parseExpression("1 * a"));
		isNotAValidExpression(parseExpression("1 * true"));
		isNotAValidExpression(parseExpression("true * true"));
	}
	
	@Test
	public void testDivs() throws ParseError {
		isAValidExpression(parseExpression("10 / 2"));
		isAValidExpression(parseExpression("10 / (2 * 1)"));
		isAValidExpression(parseExpression("10 / (2 * 2.50)"));
		
		isNotAValidExpression(parseExpression("1 / a"));
		isNotAValidExpression(parseExpression("1 / true"));
		isNotAValidExpression(parseExpression("true / true"));
	}
	
	@Test
	public void testSubs() throws ParseError {
		isAValidExpression(parseExpression("10 - 10"));
		isAValidExpression(parseExpression("10 - (2 * 5)"));
		isAValidExpression(parseExpression("10 - (2 * 2.50)"));
		
		isNotAValidExpression(parseExpression("1 - a"));
		isNotAValidExpression(parseExpression("1 - true"));
		isNotAValidExpression(parseExpression("true - true"));
	}
}