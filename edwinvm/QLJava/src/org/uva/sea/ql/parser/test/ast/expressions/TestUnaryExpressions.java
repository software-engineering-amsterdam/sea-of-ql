package org.uva.sea.ql.parser.test.ast.expressions;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.unary.NegativeExpression;
import org.uva.sea.ql.ast.expressions.unary.NegationalExpression;
import org.uva.sea.ql.ast.expressions.unary.PositiveExpression;
import org.uva.sea.ql.parser.ParseError;

public class TestUnaryExpressions extends ExpressionParserChecker {
	@Test
	public void testNegs() throws ParseError {
		expressionMatchesASTClass("--x", NegativeExpression.class);
	}
	
	@Test
	public void testPoss() throws ParseError {
		expressionMatchesASTClass("++x", PositiveExpression.class);
	}
	
	@Test
	public void testNots() throws ParseError {
		expressionMatchesASTClass("!hasBoughtHouse", NegationalExpression.class);
	}
}