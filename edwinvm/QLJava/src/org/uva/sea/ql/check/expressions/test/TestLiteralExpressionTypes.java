package org.uva.sea.ql.check.expressions.test;

import org.junit.Test;
import org.uva.sea.ql.parser.ParseError;

public class TestLiteralExpressionTypes extends ExpressionTypeChecker {
	
	@Test
	public void testIds() throws ParseError {
		isOfTypeIdent("boolean");
		isOfTypeIdent("integer");
		isOfTypeIdent("money");
		isOfTypeIdent("string");
	}
	
	@Test
	public void testNums() throws ParseError {
		isOfTypeInt("0");
		isOfTypeInt("123");
	}
	
	@Test
	public void testMoneys() throws ParseError {
		isOfTypeMoney("125.50");
		isOfTypeMoney("125,50");
	}
	
	@Test
	public void testBooleans() throws ParseError {
		isOfTypeBoolean("true");
	}
	
	@Test
	public void testStrings() throws ParseError {
		isOfTypeString("\"a\"");
		isOfTypeString("\"abc\"");
		isOfTypeString("\"ABC\"");
		isOfTypeString("\"abc2323\"");
		isOfTypeString("\"a2bc232ABC\"");
	}
	
}