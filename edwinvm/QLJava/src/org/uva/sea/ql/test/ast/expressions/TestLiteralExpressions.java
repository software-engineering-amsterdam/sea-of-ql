package org.uva.sea.ql.test.ast.expressions;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.values.Bool;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.values.Money;
import org.uva.sea.ql.ast.values.Str;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestLiteralExpressions extends ExpressionParserChecker {
	@Test
	public void testIdentifiers() throws ParseError {
		expressionMatchesASTClass("a",              Identifier.class);
		expressionMatchesASTClass("abc",            Identifier.class);
		expressionMatchesASTClass("ABC",            Identifier.class);
		expressionMatchesASTClass("abc2323",        Identifier.class);
		expressionMatchesASTClass("a2bc232aBaC",    Identifier.class);
	}
	
	@Test
	public void testIntegers() throws ParseError {
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