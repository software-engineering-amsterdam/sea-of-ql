package org.uva.sea.ql.parser.test.values;

import org.junit.Test;
import org.uva.sea.ql.parser.errors.ParseError;

public class TestBinaryArithmeticExpressionValues extends ExpressionValueChecker {
	@Test
	public void testAdds() throws ParseError {
		expressionMatchesValue("1 + 1", "2");
		expressionMatchesValue("1 + (2 + 3)", "6");
		//expressionMatchesValue("2.0 + 3.0", "5.0");
	}
	
	@Test
	public void testMuls() throws ParseError {
		expressionMatchesValue("1 * 1", "1");
		expressionMatchesValue("1 * (2 * 3)", "6");
		//expressionMatchesValue("1 * (2 * 3.0)", "6.0");
	}
	
	@Test
	public void testDivs() throws ParseError {
		expressionMatchesValue("10 / 2", "5");
		expressionMatchesValue("10 / (2 * 1)", "5");
		//expressionMatchesValue("10 / (2 * 2.50)", "2");
	}
	
	@Test
	public void testSubs() throws ParseError {
		expressionMatchesValue("10 - 10", "0");
		expressionMatchesValue("10 - (2 * 5)", "0");
		//expressionMatchesValue("10 - (2 * 2.50)", "5");
	}
}