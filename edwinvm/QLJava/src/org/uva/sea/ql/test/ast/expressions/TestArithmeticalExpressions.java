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
	public void testAdditions() throws ParseError {
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
	public void testMultiplies() throws ParseError {
		expressionMatchesASTClass("a * b",       Multiplication.class);
		expressionMatchesASTClass("a * b * c",   Multiplication.class);
		expressionMatchesASTClass("a * (b * c)", Multiplication.class);
		expressionMatchesASTClass("(a * b) * c", Multiplication.class);
		expressionMatchesASTClass("(a * b)",     Multiplication.class);
		expressionMatchesASTClass("(a + b) * c", Multiplication.class);
		expressionMatchesASTClass("a * (b + c)", Multiplication.class);
	}
	
	@Test
	public void testDivisions() throws ParseError {
		expressionMatchesASTClass("a / b",       Division.class);
		expressionMatchesASTClass("a / (b * c)", Division.class);
	}
	
	@Test
	public void testSubtractions() throws ParseError {
		expressionMatchesASTClass("a - b",       Subtraction.class);
		expressionMatchesASTClass("a - (b * c)", Subtraction.class);
	}
	
	// Unary operations
	
	@Test
	public void testNegatives() throws ParseError {
		expressionMatchesASTClass("--x",         NegativeExpression.class);
	}
	
	@Test
	public void testPositives() throws ParseError {
		expressionMatchesASTClass("++x",         PositiveExpression.class);
	}
}