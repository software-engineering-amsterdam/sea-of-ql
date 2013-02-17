package org.uva.sea.ql.parser.test.ast;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Add;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Div;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Mul;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Sub;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.test.ExpressionParserChecker;

public class TestBinaryArithmeticExpressions extends ExpressionParserChecker {
	@Test
	public void testAdds() throws ParseError {
		expressionMatchesASTClass("a + b",       Add.class);
		expressionMatchesASTClass("a + b",       Add.class);
		expressionMatchesASTClass("a + b + c",   Add.class);
		expressionMatchesASTClass("(a + b + c)", Add.class);
		expressionMatchesASTClass("a + (b + c)", Add.class);
		expressionMatchesASTClass("(a + b) + c", Add.class);
		expressionMatchesASTClass("(a + b)",     Add.class);
		expressionMatchesASTClass("a + b * c",   Add.class);
		expressionMatchesASTClass("a * b + c",   Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		expressionMatchesASTClass("a * b",       Mul.class);
		expressionMatchesASTClass("a * b * c",   Mul.class);
		expressionMatchesASTClass("a * (b * c)", Mul.class);
		expressionMatchesASTClass("(a * b) * c", Mul.class);
		expressionMatchesASTClass("(a * b)",     Mul.class);
		expressionMatchesASTClass("(a + b) * c", Mul.class);
		expressionMatchesASTClass("a * (b + c)", Mul.class);
	}
	
	@Test
	public void testDivs() throws ParseError {
		expressionMatchesASTClass("a / b",       Div.class);
		expressionMatchesASTClass("a / (b * c)", Div.class);
	}
	
	@Test
	public void testSubs() throws ParseError {
		expressionMatchesASTClass("a - b",       Sub.class);
		expressionMatchesASTClass("a - (b * c)", Sub.class);
	}
}