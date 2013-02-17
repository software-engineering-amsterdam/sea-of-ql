package org.uva.sea.ql.tests.visitor.exprevaluator;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.visitors.ExprEvaluator;

public class TestBoolExpressions {
	
	private final Map<String, Value> env = new HashMap<String, Value>();
	private final IParse parser = new ANTLRParser();
	private final ExprEvaluator eval = new ExprEvaluator(env);
	
	@Test
	public void testGT() throws ParseError {
		assertEquals(true , parser.parseExpr("20 > 5").accept(eval).getValue());
		assertEquals(true , parser.parseExpr("20.00 > 5.00").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("2 > 5").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("25.00 > 30.00").accept(eval).getValue());
	}
	
	@Test
	public void testLT() throws ParseError {
		assertEquals(true , parser.parseExpr("2 < 5").accept(eval).getValue());
		assertEquals(true , parser.parseExpr("2.00 < 5.00").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("20 < 5").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("250.00 < 30.00").accept(eval).getValue());
	}
	
	@Test
	public void testEq() throws ParseError {
		assertEquals(true , parser.parseExpr("2 == 2").accept(eval).getValue());
		assertEquals(true , parser.parseExpr("2.00 == 2.00").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("20 == 5").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("250.00 == 30.00").accept(eval).getValue());
		assertEquals(true , parser.parseExpr("true == true").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("true == false").accept(eval).getValue());
	}
	
	@Test
	public void testNEq() throws ParseError {
		assertEquals(false , parser.parseExpr("2 != 2").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("2.00 != 2.00").accept(eval).getValue());
		assertEquals(true , parser.parseExpr("20 != 5").accept(eval).getValue());
		assertEquals(true , parser.parseExpr("250.00 != 30.00").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("true != true").accept(eval).getValue());
		assertEquals(true , parser.parseExpr("true != false").accept(eval).getValue());
	}
	
	@Test
	public void testGEq() throws ParseError {
		assertEquals(true , parser.parseExpr("5 >= 5").accept(eval).getValue());
		assertEquals(true , parser.parseExpr("20.00 >= 20.00").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("4 >= 5").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("25.00 >= 30.00").accept(eval).getValue());
	}
	
	@Test
	public void testLEq() throws ParseError {
		assertEquals(true , parser.parseExpr("5 <= 5").accept(eval).getValue());
		assertEquals(true , parser.parseExpr("2.00 <= 5.00").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("20 <= 5").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("250.00 <= 30.00").accept(eval).getValue());
	}
	
	@Test
	public void testNot() throws ParseError {
		assertEquals(true , parser.parseExpr("!false").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("!true").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("!(true && true)").accept(eval).getValue());
	}
	
	@Test
	public void testAnd() throws ParseError {
		assertEquals(true , parser.parseExpr("true && true").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("true && false").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("(3 >5) && (9>10)").accept(eval).getValue());
	}
	
	@Test
	public void testOr() throws ParseError {
		assertEquals(true , parser.parseExpr("true || true").accept(eval).getValue());
		assertEquals(true , parser.parseExpr("true || false").accept(eval).getValue());
		assertEquals(false , parser.parseExpr("(3 >5) || (9>10)").accept(eval).getValue());
	}

}
