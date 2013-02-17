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

public class TestIntExpressions {

	private final Map<String, Value> env = new HashMap<String, Value>();
	private final IParse parser = new ANTLRParser();
	private final ExprEvaluator eval = new ExprEvaluator(env);
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(15 , parser.parseExpr("10 + 5").accept(eval).getValue());
		assertEquals(15 , parser.parseExpr("10 + 2 + 3").accept(eval).getValue());
		assertEquals(15 , parser.parseExpr("(5 + 5 + 5)").accept(eval).getValue());
		assertEquals(15 , parser.parseExpr("5 + (5 + 5)").accept(eval).getValue());
		assertEquals(15 , parser.parseExpr("(5 + 5) + 5").accept(eval).getValue());
		assertEquals(10 , parser.parseExpr("(5 + 5)").accept(eval).getValue());
		assertEquals(15 , parser.parseExpr("5 + 5 * 2").accept(eval).getValue());
		assertEquals(15 , parser.parseExpr("2 * 5 + 5").accept(eval).getValue());
	}

	@Test
	public void testSubs() throws ParseError {
		assertEquals(15 , parser.parseExpr("20 - 5").accept(eval).getValue());
		assertEquals(15 , parser.parseExpr("20 - 2 - 3").accept(eval).getValue());
		assertEquals(15 , parser.parseExpr("(25 - 5 - 5)").accept(eval).getValue());
		assertEquals(15 , parser.parseExpr("25 - (5 + 5)").accept(eval).getValue());
		assertEquals(15 , parser.parseExpr("(10 + 10) - 5").accept(eval).getValue());
		assertEquals(10 , parser.parseExpr("(20 - 10)").accept(eval).getValue());
		assertEquals(15 , parser.parseExpr("30 - 5 * 3").accept(eval).getValue());
		assertEquals(15 , parser.parseExpr("2 * 10 - 5").accept(eval).getValue());
	} 

	@Test
	public void testUnaries() throws ParseError {
		assertEquals(15 , parser.parseExpr(" + 15").accept(eval).getValue());
		assertEquals(-15 , parser.parseExpr(" - 15").accept(eval).getValue());
		assertEquals(15 , parser.parseExpr(" +(25 - 5 - 5)").accept(eval).getValue());
		assertEquals(-15 , parser.parseExpr("-(25 - (5 + 5))").accept(eval).getValue());
		assertEquals(-25 , parser.parseExpr("-(10 + 10) - 5").accept(eval).getValue());
		assertEquals(-10 , parser.parseExpr("-(20 - 10)").accept(eval).getValue());
		assertEquals(-15 , parser.parseExpr("-1 * (30 - 5 * 3)").accept(eval).getValue());
	}
	
	@Test
	public void testMul() throws ParseError {
		assertEquals(100 , parser.parseExpr("20 * 5").accept(eval).getValue());
		assertEquals(120 , parser.parseExpr("20 * 2 * 3").accept(eval).getValue());
		assertEquals(125 , parser.parseExpr("(5 * 5 * 5)").accept(eval).getValue());
		assertEquals(250 , parser.parseExpr("25 * (5 + 5)").accept(eval).getValue());
		assertEquals(100 , parser.parseExpr("(10 + 10) * 5").accept(eval).getValue());
		assertEquals(200 , parser.parseExpr("(20 * 10)").accept(eval).getValue());
		assertEquals(80 , parser.parseExpr("10 * (5 + 3)").accept(eval).getValue());
	}
	
	@Test
	public void testDivs() throws ParseError {
		assertEquals(4 , parser.parseExpr("20 / 5").accept(eval).getValue());
		assertEquals(11 , parser.parseExpr("(20 + 2) / 2").accept(eval).getValue());
		assertEquals(5 , parser.parseExpr("(5 * 5) / 5)").accept(eval).getValue());
		assertEquals(5 , parser.parseExpr("25 / (2 + 3)").accept(eval).getValue());
	}
}
