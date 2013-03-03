package org.uva.sea.ql.test.values;

import org.junit.Test;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestUnaryExpressions extends ExpressionValueChecker {
	@Test
	public void testNegs() throws ParseError {
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
	public void testPoss() throws ParseError {
		expressionMatchesValue("+1", "1");
		expressionMatchesValue("++1", "1");
		expressionMatchesValue("+-1", "1");
		
		expressionMatchesValue("+1.0", "1.0");
		expressionMatchesValue("++1.0", "1.0");
		expressionMatchesValue("+-1.0", "1.0");
	}
	
	@Test
	public void testNots() throws ParseError {
		expressionMatchesValue("!true", "false");
		expressionMatchesValue("!false", "true");
		expressionMatchesValue("true || !true", "true");
		expressionMatchesValue("true || !false", "true");
		expressionMatchesValue("false || !true", "false");
	}
}