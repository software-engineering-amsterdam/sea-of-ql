package org.uva.sea.ql.test.values;

import org.junit.Test;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestLogicalExpressionValues extends ExpressionValueChecker {
	@Test
	public void testAnds() throws ParseError {
		expressionMatchesValue("true && true",   "true");
		expressionMatchesValue("true && false",  "false");
		expressionMatchesValue("false && false", "false");
	}
	
	@Test
	public void testOrs() throws ParseError {
		expressionMatchesValue("true || true",   "true");
		expressionMatchesValue("true || false",  "true");
		expressionMatchesValue("false || false", "false");
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