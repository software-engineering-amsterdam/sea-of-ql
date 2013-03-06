package org.uva.sea.ql.test.ast.expressions;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.relational.EqualToExpression;
import org.uva.sea.ql.ast.expressions.relational.GreaterThanExpression;
import org.uva.sea.ql.ast.expressions.relational.GreaterThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.relational.LessThanExpression;
import org.uva.sea.ql.ast.expressions.relational.LessThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.relational.NotEqualToExpression;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestRelationalExpressions extends ExpressionParserChecker {
	@Test
	public void testRelationalExpressions() throws ParseError {
		expressionMatchesASTClass("a < b",       LessThanExpression.class);
		expressionMatchesASTClass("a < b + c",   LessThanExpression.class);
		expressionMatchesASTClass("a < (b * c)", LessThanExpression.class);
		expressionMatchesASTClass("(a * b) < c", LessThanExpression.class);
		
		expressionMatchesASTClass("(a == b)",    EqualToExpression.class);
		expressionMatchesASTClass("(a <= b)",    LessThanOrEqualToExpression.class);
		expressionMatchesASTClass("(a >= b)",    GreaterThanOrEqualToExpression.class);
		expressionMatchesASTClass("(a != b)",    NotEqualToExpression.class);
		
		expressionMatchesASTClass("a + b > c",   GreaterThanExpression.class);
		expressionMatchesASTClass("a > b + c",   GreaterThanExpression.class);
	}
}