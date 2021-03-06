package org.uva.sea.ql.test.types;

import org.junit.Test;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestRelationalExpressionTypes extends ExpressionTypeChecker {
	@Test
	public void testRelationalExpressionTypes() throws ParseError {
		isAValidExpression("1 < 2");
		isAValidExpression("1 < 1 + 1");
		isAValidExpression("1 + 2 > 2");
		
		isAValidExpression("1 == 1");
		isAValidExpression("true == true");
		
		isAValidExpression("1 <= 2");
		isAValidExpression("2 >= 1");
		isAValidExpression("1 != 2");
		
		isNotAValidExpression("1 < a");
		isNotAValidExpression("1 >= true");
		isNotAValidExpression("1.0 == a");
	}
}