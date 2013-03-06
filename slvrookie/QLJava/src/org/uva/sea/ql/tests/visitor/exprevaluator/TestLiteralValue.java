package org.uva.sea.ql.tests.visitor.exprevaluator;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.visitors.rendering.ExprEvaluator;

public class TestLiteralValue {
	
	private final Map<String, Value> env = new HashMap<String, Value>();
	private final IParse parser = new ANTLRParser();
	private final ExprEvaluator eval = new ExprEvaluator(env);

	@Test
	public void testBooleanLiteral() throws ParseError {
		assertEquals( true, parser.parseExpr("true").accept(eval).getValue() );
		assertEquals( false, parser.parseExpr("false").accept(eval).getValue() );
	}

	@Test
	public void testIntegerLiteral() throws ParseError {
		assertEquals( 10.00, parser.parseExpr("10.00").accept(eval).getValue() );
		assertEquals( 0.15, parser.parseExpr("0.15").accept(eval).getValue() );
		assertEquals( -0.15, parser.parseExpr("-0.15").accept(eval).getValue());
	}

	@Test
	public void testMoneyLiteral() throws ParseError {
		assertEquals( 1, parser.parseExpr("1").accept(eval).getValue() );
		assertEquals( -1, parser.parseExpr("-1").accept(eval).getValue() );
		assertEquals( 0, parser.parseExpr("0").accept(eval).getValue() );
	}

	@Test
	public void testStringLiteral() throws ParseError {
		assertEquals( "\"karate\"", parser.parseExpr("\"karate\"").accept(eval).getValue() );
		assertEquals( "\"\"", parser.parseExpr("\"\"").accept(eval).getValue() );
	}
	
}
