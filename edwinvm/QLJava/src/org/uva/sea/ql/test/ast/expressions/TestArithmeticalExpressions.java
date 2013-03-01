package org.uva.sea.ql.test.ast.expressions;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.arithmetic.Addition;
import org.uva.sea.ql.ast.expressions.arithmetic.Division;
import org.uva.sea.ql.ast.expressions.arithmetic.Multiplication;
import org.uva.sea.ql.ast.expressions.arithmetic.NegativeExpression;
import org.uva.sea.ql.ast.expressions.arithmetic.PositiveExpression;
import org.uva.sea.ql.ast.expressions.arithmetic.Subtraction;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestArithmeticalExpressions extends ExpressionParserChecker {
	@Test
	public void testAdds() throws ParseError {
		expressionMatchesASTClass("a + b",       Addition.class);
		expressionMatchesASTClass("a + b",       Addition.class);
		expressionMatchesASTClass("a + b + c",   Addition.class);
		expressionMatchesASTClass("(a + b + c)", Addition.class);
		expressionMatchesASTClass("a + (b + c)", Addition.class);
		expressionMatchesASTClass("(a + b) + c", Addition.class);
		expressionMatchesASTClass("(a + b)",     Addition.class);
		expressionMatchesASTClass("a + b * c",   Addition.class);
		expressionMatchesASTClass("a * b + c",   Addition.class);
	}

	@Test
	public void testMuls() throws ParseError {
		expressionMatchesASTClass("a * b",       Multiplication.class);
		expressionMatchesASTClass("a * b * c",   Multiplication.class);
		expressionMatchesASTClass("a * (b * c)", Multiplication.class);
		expressionMatchesASTClass("(a * b) * c", Multiplication.class);
		expressionMatchesASTClass("(a * b)",     Multiplication.class);
		expressionMatchesASTClass("(a + b) * c", Multiplication.class);
		expressionMatchesASTClass("a * (b + c)", Multiplication.class);
	}
	
	@Test
	public void testDivs() throws ParseError {
		expressionMatchesASTClass("a / b",       Division.class);
		expressionMatchesASTClass("a / (b * c)", Division.class);
	}
	
	@Test
	public void testSubs() throws ParseError {
		expressionMatchesASTClass("a - b",       Subtraction.class);
		expressionMatchesASTClass("a - (b * c)", Subtraction.class);
	}
	
	// Unary operations
	
	@Test
	public void testNegs() throws ParseError {
		expressionMatchesASTClass("--x", NegativeExpression.class);
	}
	
	@Test
	public void testPoss() throws ParseError {
		expressionMatchesASTClass("++x", PositiveExpression.class);
	}
}