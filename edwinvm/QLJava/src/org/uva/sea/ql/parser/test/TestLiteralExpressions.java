package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.literal.Bool;
import org.uva.sea.ql.ast.expressions.literal.Ident;
import org.uva.sea.ql.ast.expressions.literal.Int;
import org.uva.sea.ql.ast.expressions.literal.Money;
import org.uva.sea.ql.ast.expressions.literal.Str;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.antlr.check.ANTLRParserExpressions;

public class TestLiteralExpressions {

	private IParser _parser;
	
	public TestLiteralExpressions() {
		_parser = new ANTLRParserExpressions();
	}
	
	@Test
	public void testIds() throws ParseError {
		assertEquals(_parser.parse("a").getClass(), Ident.class);
		assertEquals(_parser.parse("abc").getClass(), Ident.class);
		assertEquals(_parser.parse("ABC").getClass(), Ident.class);
		assertEquals(_parser.parse("abc2323").getClass(), Ident.class);
		assertEquals(_parser.parse("a2bc232aBaC").getClass(), Ident.class);
	}
	
	@Test
	public void testNums() throws ParseError {
		assertEquals(_parser.parse("0").getClass(), Int.class);
		assertEquals(_parser.parse("123").getClass(), Int.class);
	}
	
	@Test
	public void testMoneys() throws ParseError {
		assertEquals(_parser.parse("125.50").getClass(), Money.class);
		assertEquals(_parser.parse("125,00").getClass(), Money.class);
	}
	
	@Test
	public void testBooleans() throws ParseError {
		assertEquals(_parser.parse("true").getClass(), Bool.class);
		assertEquals(_parser.parse("false").getClass(), Bool.class);
	}
	
	@Test
	public void testStrings() throws ParseError {
		assertEquals(_parser.parse("\"a\"").getClass(), Str.class);
		assertEquals(_parser.parse("\"abc\"").getClass(), Str.class);
		assertEquals(_parser.parse("\"ABC\"").getClass(), Str.class);
		assertEquals(_parser.parse("\"abc2323\"").getClass(), Str.class);
		assertEquals(_parser.parse("\"a2bc232ABC\"").getClass(), Str.class);
	}
}