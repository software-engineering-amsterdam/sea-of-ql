package org.uva.sea.ql.test.ast.expressions;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.logical.LogicallyEquivalentExpression;
import org.uva.sea.ql.ast.expressions.logical.LogicallyNotEquivalentExpression;
import org.uva.sea.ql.ast.expressions.logical.NegationalExpression;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestLogicalExpressions extends ExpressionParserChecker {
	@Test
	public void testAnds() throws ParseError {
		expressionMatchesASTClass("a && b",      LogicallyEquivalentExpression.class);
		expressionMatchesASTClass("a && b <= c", LogicallyEquivalentExpression.class);
	}
	
	@Test
	public void testOrs() throws ParseError {
		expressionMatchesASTClass("a || b",      LogicallyNotEquivalentExpression.class);
		expressionMatchesASTClass("a || b <= c", LogicallyNotEquivalentExpression.class);
	}
	
	@Test
	public void testNots() throws ParseError {
		expressionMatchesASTClass("!hasBoughtHouse", NegationalExpression.class);
	}
}