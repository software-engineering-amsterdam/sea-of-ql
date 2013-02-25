package org.uva.sea.ql.parser.test.values;

import org.junit.Test;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestBinaryRelationalExpressionValues extends ExpressionValueChecker {
	@Test
	public void testEquality() throws ParseError {
		expressionMatchesValue("1 == 1", "true");
		expressionMatchesValue("1 == 0", "false");
		
		expressionMatchesValue("true == true",   "true");
		expressionMatchesValue("true == false",  "false");
		expressionMatchesValue("false == false", "true");
		
		expressionMatchesValue("1.0 == 1.0", "true");
		expressionMatchesValue("1.0 == 2.0", "false");
		
		expressionMatchesValue("\"a\" == \"a\"", "true");
		expressionMatchesValue("\"a\" == \"b\"", "false");
	}
	
	@Test
	public void testNonEquality() throws ParseError {
		expressionMatchesValue("1 != 2", "true");
		expressionMatchesValue("1 != 1", "false");
		
		expressionMatchesValue("true != false",  "true");
		expressionMatchesValue("true != true",   "false");
		expressionMatchesValue("false != false", "false");
		
		expressionMatchesValue("1.0 != 1.0", "false");
		expressionMatchesValue("1.0 != 2.0", "true");
		
		expressionMatchesValue("\"a\" != \"a\"", "false");
		expressionMatchesValue("\"a\" != \"b\"", "true");
	}
	
	@Test
	public void testGreaterThan() throws ParseError {
		expressionMatchesValue("2 > 1", "true");
		expressionMatchesValue("1 > 2", "false");
		
		expressionMatchesValue("2.0 > 1.0", "true");
		expressionMatchesValue("1.0 > 2.0", "false");
	}
	
	@Test
	public void testGreaterThanOrEqualTo() throws ParseError {
		expressionMatchesValue("2 >= 1", "true");
		expressionMatchesValue("1 >= 2", "false");
		
		expressionMatchesValue("2.0 >= 1.0", "true");
		expressionMatchesValue("1.0 >= 2.0", "false");
	}
	
	@Test
	public void testLessThan() throws ParseError {
		expressionMatchesValue("1 < 2", "true");
		expressionMatchesValue("2 < 1", "false");
		
		expressionMatchesValue("1.0 < 2.0", "true");
		expressionMatchesValue("2.0 < 1.0", "false");
	}
	
	@Test
	public void testLessThanOrEqualTo() throws ParseError {
		expressionMatchesValue("1 <= 2", "true");
		expressionMatchesValue("2 <= 1", "false");
		
		expressionMatchesValue("1.0 <= 2.0", "true");
		expressionMatchesValue("2.0 <= 1.0", "false");
	}
}