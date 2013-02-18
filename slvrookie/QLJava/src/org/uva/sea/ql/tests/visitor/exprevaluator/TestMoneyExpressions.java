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

public class TestMoneyExpressions {
	
	private final Map<String, Value> env = new HashMap<String, Value>();
	private final IParse parser = new ANTLRParser();
	private final ExprEvaluator eval = new ExprEvaluator(env);
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(15.00 , parser.parseExpr("10.00 + 5.00").accept(eval).getValue());
		assertEquals(15.00 , parser.parseExpr("10.00 + 2.00 + 3.00").accept(eval).getValue());
		assertEquals(15.00 , parser.parseExpr("(5.00 + 5.00 + 5.00)").accept(eval).getValue());
		assertEquals(15.00 , parser.parseExpr("5.00 + (5.00 + 5.00)").accept(eval).getValue());
		assertEquals(15.00 , parser.parseExpr("(5.00 + 5.00) + 5.00").accept(eval).getValue());
		assertEquals(10.00 , parser.parseExpr("(5.00 + 5.00)").accept(eval).getValue());
		assertEquals(15.00 , parser.parseExpr("5.00 + 5.00 * 2.00").accept(eval).getValue());
		assertEquals(15.00 , parser.parseExpr("2.00 * 5.00 + 5.00").accept(eval).getValue());
	}

	@Test
	public void testSubs() throws ParseError {
		assertEquals(15.00 , parser.parseExpr("20.00 - 5.00").accept(eval).getValue());
		assertEquals(15.00 , parser.parseExpr("20.00 - 2.00 - 3.00").accept(eval).getValue());
		assertEquals(15.00 , parser.parseExpr("(25.00 - 5.00 - 5.00)").accept(eval).getValue());
		assertEquals(15.00 , parser.parseExpr("25.00 - (5.00 + 5.00)").accept(eval).getValue());
		assertEquals(15.00 , parser.parseExpr("(10.00 + 10.00) - 5.00").accept(eval).getValue());
		assertEquals(10.00 , parser.parseExpr("(20.00 - 10.00)").accept(eval).getValue());
		assertEquals(15.00 , parser.parseExpr("30.00 - 5.00 * 3.00").accept(eval).getValue());
		assertEquals(15.00 , parser.parseExpr("2.00 * 10.00 - 5.00").accept(eval).getValue());
	} 

	@Test
	public void testUnaries() throws ParseError {
		assertEquals(15.00 , parser.parseExpr(" + 15.00").accept(eval).getValue());
		assertEquals(-15.00 , parser.parseExpr(" - 15.00").accept(eval).getValue());
		assertEquals(15.00 , parser.parseExpr(" +(25.00 - 5.00 - 5.00)").accept(eval).getValue());
		assertEquals(-15.00 , parser.parseExpr("-(25.00 - (5.00 + 5.00))").accept(eval).getValue());
		assertEquals(-25.00 , parser.parseExpr("-(10.00 + 10.00) - 5.00").accept(eval).getValue());
		assertEquals(-10.00 , parser.parseExpr("-(20.00 - 10.00)").accept(eval).getValue());
		assertEquals(-15.00 , parser.parseExpr("-1.00 * (30.00 - 5.00 * 3.00)").accept(eval).getValue());
	}
	
	@Test
	public void testMul() throws ParseError {
		assertEquals(100.00 , parser.parseExpr("20.00 * 5.00").accept(eval).getValue());
		assertEquals(120.00 , parser.parseExpr("20.00 * 2.00 * 3.00").accept(eval).getValue());
		assertEquals(125.00 , parser.parseExpr("(5.00 * 5.00 * 5.00)").accept(eval).getValue());
		assertEquals(250.00 , parser.parseExpr("25.00 * (5.00 + 5.00)").accept(eval).getValue());
		assertEquals(100.00 , parser.parseExpr("(10.00 + 10.00) * 5.00").accept(eval).getValue());
		assertEquals(200.00 , parser.parseExpr("(20.00 * 10.00)").accept(eval).getValue());
		assertEquals(80.00 , parser.parseExpr("10.00 * (5.00 + 3.00)").accept(eval).getValue());
	}
	
	@Test
	public void testDivs() throws ParseError {
		assertEquals(4.00 , parser.parseExpr("20.00 / 5.00").accept(eval).getValue());
		assertEquals(11.00 , parser.parseExpr("(20.00 + 2.00) / 2.00").accept(eval).getValue());
		assertEquals(5.00 , parser.parseExpr("(5.00 * 5.00) / 5.00)").accept(eval).getValue());
		assertEquals(5.00 , parser.parseExpr("25.00 / (2.00 + 3.00)").accept(eval).getValue());
	}

}
