package org.uva.sea.ql.parser.test.ast;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.literal.Bool;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.expressions.literal.Int;
import org.uva.sea.ql.ast.expressions.literal.Money;
import org.uva.sea.ql.ast.expressions.literal.Str;
import org.uva.sea.ql.parser.ParseError;

public class TestLiteralExpressions extends ExpressionParserChecker {
	@Test
	public void testIds() throws ParseError {
		expressionMatchesASTClass("a",              Ident.class);
		expressionMatchesASTClass("abc",            Ident.class);
		expressionMatchesASTClass("ABC",            Ident.class);
		expressionMatchesASTClass("abc2323",        Ident.class);
		expressionMatchesASTClass("a2bc232aBaC",    Ident.class);
	}
	
	@Test
	public void testNums() throws ParseError {
		expressionMatchesASTClass("0",              Int.class);
		expressionMatchesASTClass("123",            Int.class);
	}
	
	@Test
	public void testMoneys() throws ParseError {
		expressionMatchesASTClass("125.50",         Money.class);
		expressionMatchesASTClass("125,00",         Money.class);
	}
	
	@Test
	public void testBooleans() throws ParseError {
		expressionMatchesASTClass("true",           Bool.class);
		expressionMatchesASTClass("false",          Bool.class);
	}
	
	@Test
	public void testStrings() throws ParseError {
		expressionMatchesASTClass("\"a\"",          Str.class);
		expressionMatchesASTClass("\"abc\"",        Str.class);
		expressionMatchesASTClass("\"ABC\"",        Str.class);
		expressionMatchesASTClass("\"abc2323\"",    Str.class);
		expressionMatchesASTClass("\"a2bc232ABC\"", Str.class);
	}
}