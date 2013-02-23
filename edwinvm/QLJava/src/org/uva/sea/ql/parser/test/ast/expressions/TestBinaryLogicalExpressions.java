package org.uva.sea.ql.parser.test.ast.expressions;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binary.logical.LogicallyEquivalentExpression;
import org.uva.sea.ql.ast.expressions.binary.logical.LogicallyNotEquivalentExpression;
import org.uva.sea.ql.parser.ParseError;

public class TestBinaryLogicalExpressions extends ExpressionParserChecker {
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
}