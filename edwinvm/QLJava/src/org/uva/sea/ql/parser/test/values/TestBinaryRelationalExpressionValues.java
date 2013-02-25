package org.uva.sea.ql.parser.test.values;

import org.junit.Test;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestBinaryRelationalExpressionValues extends ExpressionValueChecker {
	@Test
	public void testRels() throws ParseError {
		expressionMatchesValue("1 == 1", "true");
	}
}