package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Add;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Div;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Mul;
import org.uva.sea.ql.ast.expressions.binary.arithmetic.Sub;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;

public class TestBinaryArithmeticExpressions {

	private IParser _parser;
	
	public TestBinaryArithmeticExpressions() {
		_parser = new ANTLRParserExpressions();
	}
	
	private void expressionMatchesASTClass(String input, Class<?> astNode) throws ParseError {
		assertEquals(_parser.parse(input).getClass(), astNode);
	}
	
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