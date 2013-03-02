package org.uva.sea.ql.test.values;

import org.junit.Test;
import org.uva.sea.ql.ast.values.Str;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestArithmeticalExpressionValues extends ExpressionValueChecker {
	@Test
	public void testAdditions() throws ParseError {
		expressionMatchesValue("1 + 1", "2");
		expressionMatchesValue("1 + (2 + 3)", "6");
		expressionMatchesValue("2.0 + 3.0", "5.0");
		
		expressionMatchesValue("\"a\" + \"b\"", "\"a b\"");
		
		expressionMatchesValue(new Str("a").add(new Str("b")), new Str("a b"));
	}
	
	@Test
	public void testMultiplies() throws ParseError {
		expressionMatchesValue("1 * 1", "1");
		expressionMatchesValue("1 * (2 * 3)", "6");
		expressionMatchesValue("2.0 * 3.0", "6.0");
	}
	
	@Test
	public void testDivisions() throws ParseError {
		expressionMatchesValue("10 / 2", "5");
		expressionMatchesValue("10 / (2 * 1)", "5");
		expressionMatchesValue("10.0 / (2.0 * 2.50)", "2.0");
	}
	
	@Test
	public void testSubtractions() throws ParseError {
		expressionMatchesValue("10 - 10", "0");
		expressionMatchesValue("10 - (2 * 5)", "0");
		expressionMatchesValue("10.0 - (2.0 * 2.50)", "5.0");
	}
	
	// Unary operations
	
	@Test
	public void testNegatives() throws ParseError {
		expressionMatchesValue("-1", "-1");
		expressionMatchesValue("--1", "1");
		expressionMatchesValue("-(+1)", "-1");
		expressionMatchesValue("--(--1)", "1");
		
		expressionMatchesValue("-1.0", "-1.0");
		expressionMatchesValue("--1.0", "1.0");
		expressionMatchesValue("-(+1.0)", "-1.0");
		expressionMatchesValue("--(--1.0)", "1.0");
	}
	
	@Test
	public void testPositives() throws ParseError {
		expressionMatchesValue("+1", "1");
		expressionMatchesValue("++1", "1");
		expressionMatchesValue("+-1", "1");
		
		expressionMatchesValue("+1.0", "1.0");
		expressionMatchesValue("++1.0", "1.0");
		expressionMatchesValue("+-1.0", "1.0");
	}
}