package org.uva.sea.ql.parser.test.ast;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.unary.Neg;
import org.uva.sea.ql.ast.expressions.unary.Not;
import org.uva.sea.ql.ast.expressions.unary.Pos;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.test.ExpressionParserChecker;

public class TestUnaryExpressions extends ExpressionParserChecker {
	@Test
	public void testNegs() throws ParseError {
		expressionMatchesASTClass("--x", Neg.class);
	}
	
	@Test
	public void testPoss() throws ParseError {
		expressionMatchesASTClass("++x", Pos.class);
	}
	
	@Test
	public void testNots() throws ParseError {
		expressionMatchesASTClass("!hasBoughtHouse", Not.class);
	}
}