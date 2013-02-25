package org.uva.sea.ql.parser.test.values;

import org.junit.Test;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestBinaryRelationalExpressionValues extends ExpressionValueChecker {
	@Test
	public void testEquality() throws ParseError {
		expressionMatchesValue("1 == 1", "true");
		expressionMatchesValue("1 == 0", "false");
		
		expressionMatchesValue("true == true", "true");
		expressionMatchesValue("true == false", "false");
		expressionMatchesValue("false == false", "true");
		
		expressionMatchesValue("1.0 == 1.0", "true");
		expressionMatchesValue("1.0 == 2.0", "false");
		
		expressionMatchesValue("\"a\" == \"a\"", "true");
		expressionMatchesValue("\"a\" == \"b\"", "false");
	}
}