package org.uva.sea.ql.parser.test.values;

import org.junit.Test;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestBinaryLogicalExpressionValues extends ExpressionValueChecker {
	@Test
	public void testAnds() throws ParseError {
		expressionMatchesValue("true && true", "true");
	}
}