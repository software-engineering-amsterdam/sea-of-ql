package org.uva.sea.ql.test.ast.expressions;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.logical.LogicallyEquivalentExpression;
import org.uva.sea.ql.ast.expressions.logical.LogicallyEquivalentOrNotExpression;
import org.uva.sea.ql.ast.expressions.logical.NegationalExpression;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestLogicalExpressions extends ExpressionParserChecker {
	@Test
	public void testLogicallyEquivalentExpressions() throws ParseError {
		expressionMatchesASTClass("a && b",          LogicallyEquivalentExpression.class);
		expressionMatchesASTClass("a && b <= c",     LogicallyEquivalentExpression.class);
	}
	
	@Test
	public void testLogicallyEquivalentOrNotExpressions() throws ParseError {
		expressionMatchesASTClass("a || b",          LogicallyEquivalentOrNotExpression.class);
		expressionMatchesASTClass("a || b <= c",     LogicallyEquivalentOrNotExpression.class);
	}
	
	@Test
	public void testNegations() throws ParseError {
		expressionMatchesASTClass("!hasBoughtHouse", NegationalExpression.class);
	}
}