package org.uva.sea.ql.test.values;

import org.junit.Test;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestLogicalExpressionValues extends ExpressionValueChecker {
	@Test
	public void testLogicallyEquivalentExpressionValues() throws ParseError {
		expressionMatchesValue("true && true",   "true");
		expressionMatchesValue("true && false",  "false");
		expressionMatchesValue("false && false", "false");
	}
	
	@Test
	public void testLogicallyEquivalentOrNotExpressionValues() throws ParseError {
		expressionMatchesValue("true || true",   "true");
		expressionMatchesValue("true || false",  "true");
		expressionMatchesValue("false || false", "false");
	}
	
	@Test
	public void testNegations() throws ParseError {
		expressionMatchesValue("!true", "false");
		expressionMatchesValue("!false", "true");
		expressionMatchesValue("true || !true", "true");
		expressionMatchesValue("true || !false", "true");
		expressionMatchesValue("false || !true", "false");
	}
}