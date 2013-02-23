package org.uva.sea.ql.parser.test.ast.expressions;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binary.relational.EqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.GreaterThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.GreaterThanExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.LessThanOrEqualToExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.LessThanExpression;
import org.uva.sea.ql.ast.expressions.binary.relational.NotEqualToExpression;
import org.uva.sea.ql.parser.ParseError;

public class TestBinaryRelationalExpressions extends ExpressionParserChecker {
	@Test
	public void testRels() throws ParseError {
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