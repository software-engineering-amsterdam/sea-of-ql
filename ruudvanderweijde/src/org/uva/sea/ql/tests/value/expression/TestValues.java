package org.uva.sea.ql.tests.value.expression;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.tests.IParse;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.StringValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.valueCheck.ExpressionValueVisitor;
import org.uva.sea.ql.visitor.valueCheck.ValueMapper;

public class TestValues {
	private final IParse parser = new ANTLRParser();
	public static ValueMapper valueMapper = new ValueMapper();
	public static ArrayList<Message> errors = new ArrayList<Message>();

	@Test
	public void testStringValue() throws ParseError {
		calculateStringValue("\"a\"", "a");
		calculateStringValue("\"word\"", "word");
		calculateStringValue("\"This is a sentence.\"", "This is a sentence.");
	}

	@Test
	public void testBooleanValue() throws ParseError {
		calculateBooleanValue("false", false);
		calculateBooleanValue("true", true);
		
		calculateBooleanValue("true && true", true);
		calculateBooleanValue("true && false", false);
		calculateBooleanValue("false && false", false);
		calculateBooleanValue("false && true", false);
		
		calculateBooleanValue("true || true", true);
		calculateBooleanValue("true || false", true);
		calculateBooleanValue("false || false", false);
		calculateBooleanValue("false || true", true);
		
		// generated expressions
		calculateBooleanValue("true != !true", true);
		calculateBooleanValue("!true || true != !true", true);
		calculateBooleanValue("!false || !true == true", true);
		calculateBooleanValue("!false || true == !false", true);
		calculateBooleanValue("true == !true || true != true", false);
		calculateBooleanValue("true == !false || true != false", true);
		calculateBooleanValue("!true || false == false || !true", true);
		calculateBooleanValue("true || true == !true || !true && !false", true);
		calculateBooleanValue("!true || false || !true != !false && true", true);
		calculateBooleanValue("false && false != false && true && !false || false", false);
		calculateBooleanValue("!false && false && !true == !false == true && !false", false);
		calculateBooleanValue("!false == !false != !true && !true && !false || !true", false);
		calculateBooleanValue("true && false && !false != true == !false && !false == false", false);
		calculateBooleanValue("false != false != !false && false != !true || !true && true && true", false);
	}
	
	@Test
	public void testIntegerValueAsBooleanValues() throws ParseError {
		calculateBooleanValue("1 > 2", false);
		calculateBooleanValue("-1 > 0", false);
		calculateBooleanValue("2 > 2", false);
		calculateBooleanValue("2 >= 2", true);
		calculateBooleanValue("1 >= 2", false);
		calculateBooleanValue("1 <= 2", true);
		calculateBooleanValue("1 < 2", true);
		calculateBooleanValue("5 > 8", false);

		// generated expressions
		calculateBooleanValue("2 < 16", true);
		calculateBooleanValue("+21 > -22", true);
		calculateBooleanValue("+25 + 12 / 24 > 24", true);
		calculateBooleanValue("+19 / -7 >= +1 - 21", true);
		calculateBooleanValue("2 <= -15 - -25 - -14", true);
		calculateBooleanValue("+15 > -21 * -18 / -8 / +10", true);
		calculateBooleanValue("-24 * -20 / -1 - -22 - -13 < +20", true);
		calculateBooleanValue("-11 / -24 - +15 / +24 < +19 - +11", true);
		
		calculateBooleanValue("+7 < +2", false);
		calculateBooleanValue("9 <= +7 / -11 * +18", false);
		calculateBooleanValue("+24 * 20 <= +0 - -23", false);
		calculateBooleanValue("+13 >= -4 * +2 - -8 * 20", false);
		calculateBooleanValue("-13 - +7 >= -10 * +5 * -24", false);
	}
	
	@Test
	public void testIntegerValue() throws ParseError {
		calculateIntegerValue("1+1", 2);
		calculateIntegerValue("2+2", 4);
		calculateIntegerValue("2-1", 1);
		calculateIntegerValue("-1-1", -2);
		
		// generated expressions
		calculateIntegerValue("10 - -12", 22);
		calculateIntegerValue("+14 + +15", 29);
		calculateIntegerValue("-13 * 12", -156);
		calculateIntegerValue("+18 * 0 / 7", 0);
		calculateIntegerValue("-8 + 17 * 0", -8);
		calculateIntegerValue("8 + 5 - -19", 32);
		calculateIntegerValue("-17 + 6 + 10", -1);
		calculateIntegerValue("-13 - +1 + +7", -7);
		calculateIntegerValue("-9 - -3 - -25", 19);
		calculateIntegerValue("-4 + -5 * -20", 96);
		calculateIntegerValue("-14 * -8 + 6", 118);
		calculateIntegerValue("+23 + 14 - 15", 22);
		calculateIntegerValue("-7 - -12 * -5", -67);
		calculateIntegerValue("-16 - +4 * 20", -96);
		calculateIntegerValue("+10 - 17 * +23", -381);
		calculateIntegerValue("-13 * +11 + +2", -141);
		calculateIntegerValue("15 * +8 - +17 + 4", 107);
		calculateIntegerValue("-7 - +16 * 7 * 8", -903);
		calculateIntegerValue("-17 + -9 - -1 + -4", -29);
		calculateIntegerValue("-14 - 16 - -11 / 1", -19);
		calculateIntegerValue("+10 + 20 * +8 - +21", 149);
		calculateIntegerValue("22 / +22 + +15 + -20", -4);
		calculateIntegerValue("-17 * +21 / +21 * -9", 153);
		calculateIntegerValue("-3 - -8 + +19 + 15 + 7", 46);
		calculateIntegerValue("-23 * 3 * -4 - -7 + 10", 293);
		calculateIntegerValue("+5 - 12 + 17 + -12 + +23", 21);
		calculateIntegerValue("-22 * 5 + -22 + 19 - 15", -128);
		calculateIntegerValue("18 - -24 + 24 + -13 + +21", 74);
		calculateIntegerValue("3 + -1 * +10 * -21 + +10", 223);
		calculateIntegerValue("-4 + +1 * -21 + -9 + +12", -22);
		calculateIntegerValue("+10 * -10 - -25 + +7 + 11", -57);
		calculateIntegerValue("1 - -2 - +19 + +15 - 11 * 6", -67);
		calculateIntegerValue("-20 * -22 * 13 + +16 - +19", 5717);
		calculateIntegerValue("+1 - -11 - +11 * +21 - -17", -202);
		calculateIntegerValue("+24 * -7 - 25 * 7 + -23 - -22", -344);
		calculateIntegerValue("21 * +22 - -20 * 11 + 14 + +13", 709);
		calculateIntegerValue("11 * +1 + 6 * 14 * +20 - -4 - 2", 1693);
	}
	
	private void calculateIntegerValue(String strExpression, Integer expectedResult) throws ParseError {
		Value value = getValueByExpression(strExpression);
		assertEquals(value.getClass(), IntegerValue.class);
		Integer intValue = ((IntegerValue)value).getValue();
		assertEquals(intValue, expectedResult);
	}
	
	private void calculateBooleanValue(String strExpression, Boolean expectedResult) throws ParseError {
		Value value = getValueByExpression(strExpression);
		assertEquals(value.getClass(), BooleanValue.class);
		Boolean boolValue = ((BooleanValue)value).getValue();
		assertEquals(boolValue, expectedResult);
	}
	
	private void calculateStringValue(String strExpression, String expectedResult) throws ParseError {
		Value value = getValueByExpression(strExpression);
		assertEquals(value.getClass(), StringValue.class);
		String stringValue = ((StringValue)value).getValue();
		assertEquals(stringValue, expectedResult);
	}
	
	private Value getValueByExpression(String strExpression) throws ParseError {
		return parser.parseExpression(strExpression).accept(new ExpressionValueVisitor(valueMapper, errors));
	}
}