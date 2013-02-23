package org.uva.sea.ql.parser.test.ast.expressions;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Addition;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Division;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Multiplication;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Subtraction;
import org.uva.sea.ql.parser.ParseError;

public class TestBinaryArithmeticExpressions extends ExpressionParserChecker {
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
}