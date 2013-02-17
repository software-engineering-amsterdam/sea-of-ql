package org.uva.sea.ql.parser.test.ast;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binary.logical.And;
import org.uva.sea.ql.ast.expressions.binary.logical.Or;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.test.ExpressionParserChecker;

public class TestBinaryLogicalExpressions extends ExpressionParserChecker {
	@Test
	public void testAnds() throws ParseError {
		expressionMatchesASTClass("a && b",      And.class);
		expressionMatchesASTClass("a && b <= c", And.class);
	}
	
	@Test
	public void testOrs() throws ParseError {
		expressionMatchesASTClass("a || b",      Or.class);
		expressionMatchesASTClass("a || b <= c", Or.class);
	}
}