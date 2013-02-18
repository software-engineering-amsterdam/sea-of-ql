package org.uva.sea.ql.parser.test.types;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.test.ExpressionTypeChecker;

public class TestBinaryRelationalExpressionTypes extends ExpressionTypeChecker {
	
	@Test
	public void testRels() throws ParseError {
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