package org.uva.sea.ql.tests.semantic.expression;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.tests.IParse;
import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.IntegerValue;
import org.uva.sea.ql.value.Value;
import org.uva.sea.ql.visitor.valueCheck.ExpressionValueVisitor;
import org.uva.sea.ql.visitor.valueCheck.ValueMapper;

@RunWith(Parameterized.class)
public class TestValues {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		Object[][] data = new Object[][] { new Object[] {new ANTLRParser()} };
		return Arrays.asList(data);
	}
	public static ValueMapper valueMapper = new ValueMapper();
	public static ArrayList<Message> errors = new ArrayList<Message>();

	
	public TestValues(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testStringValue() throws ParseError {
//		calculateBooleanValue(""25 - 19 || true + 12").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""9 < 22 || 16 < 25 >= 14").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""4 > 17 == 24 == false + 25").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""23 / 23 && false <= 4").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""false >= true <= 9 && 1").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""6 <= 9 != 3 != 18 < 15").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""9 + 1 == true").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""23 != 9 < 23 > 11").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""23 || false < 2").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""6 || 6 - 21 / true").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""18 + 22 >= 7 == 24").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""false >= 12 >= false == 0 || 15").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""5 && 1 * 18 - 13 != 11").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""false != 24 * 18 / 21").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""21 && 2 - 13").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""18 > 10 <= 10 < true").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""false <= 24 / 22 < 3").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""true != false * 3").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""4 && 19 > 22 < 19 || true || 24 >= 17").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""7 && true * true < 4 * 12").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""23 * true - false / fals").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""11 / false != 6 - 1 != 18").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
//		calculateBooleanValue(""7 / 2 || true || 19 || 0").accept(new ExpressionValueVisitor(valueMapper, errors)), this);
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
		
		calculateBooleanValue("!false || true == !false", true);
		calculateBooleanValue("true || true == !true || !true && !false", true);
		calculateBooleanValue("!false && false && !true == !false == true && !false", false);
		calculateBooleanValue("!true || false || !true != !false && true", true);
		calculateBooleanValue("!false == !false != !true && !true && !false || !true", false);
		calculateBooleanValue("true == !true || true != true", false);
		calculateBooleanValue("true == !false || true != false", true);
		calculateBooleanValue("false != false != !false && false != !true || !true && true && true", false);
		calculateBooleanValue("true != !true", true);
		calculateBooleanValue("false && false != false && true && !false || false", false);
		calculateBooleanValue("!true || false == false || !true", true);
		calculateBooleanValue("true && false && !false != true == !false && !false == false", false);
		calculateBooleanValue("!true || true != !true", true);
		calculateBooleanValue("!false || !true == true", true);
		
	}
	
	@Test
	public void testIntegerValue() throws ParseError {
		calculateIntegerValue("1+1", 2);
		calculateIntegerValue("2+2", 4);
		calculateIntegerValue("2-1", 1);
		calculateIntegerValue("-1-1", -2);
		
		// generated expressions
		calculateIntegerValue("15 * +8 - +17 + 4", 107);
		calculateIntegerValue("+10 + 20 * +8 - +21", 149);
		calculateIntegerValue("-14 - 16 - -11 / 1", -19);
		calculateIntegerValue("21 * +22 - -20 * 11 + 14 + +13", 709);
		calculateIntegerValue("-7 - -12 * -5", -67);
		calculateIntegerValue("-16 - +4 * 20", -96);
		calculateIntegerValue("-4 + -5 * -20", 96);
		calculateIntegerValue("-4 + +1 * -21 + -9 + +12", -22);
		calculateIntegerValue("-23 * 3 * -4 - -7 + 10", 293);
		calculateIntegerValue("-13 * 12", -156);
		calculateIntegerValue("-14 * -8 + 6", 118);
		calculateIntegerValue("+23 + 14 - 15", 22);
		calculateIntegerValue("+10 - 17 * +23", -381);
		calculateIntegerValue("3 + -1 * +10 * -21 + +10", 223);
		calculateIntegerValue("-17 * +21 / +21 * -9", 153);
		calculateIntegerValue("+5 - 12 + 17 + -12 + +23", 21);
		calculateIntegerValue("22 / +22 + +15 + -20", -4);
		calculateIntegerValue("+18 * 0 / 7", 0);
		calculateIntegerValue("+10 * -10 - -25 + +7 + 11", -57);
		calculateIntegerValue("18 - -24 + 24 + -13 + +21", 74);
		calculateIntegerValue("-13 - +1 + +7", -7);
		calculateIntegerValue("11 * +1 + 6 * 14 * +20 - -4 - 2", 1693);
		calculateIntegerValue("-8 + 17 * 0", -8);
		calculateIntegerValue("-3 - -8 + +19 + 15 + 7", 46);
		calculateIntegerValue("1 - -2 - +19 + +15 - 11 * 6", -67);
		calculateIntegerValue("-22 * 5 + -22 + 19 - 15", -128);
		calculateIntegerValue("-9 - -3 - -25", 19);
		calculateIntegerValue("10 - -12", 22);
		calculateIntegerValue("+14 + +15", 29);
		calculateIntegerValue("+24 * -7 - 25 * 7 + -23 - -22", -344);
		calculateIntegerValue("-17 + 6 + 10", -1);
		calculateIntegerValue("-13 * +11 + +2", -141);
		calculateIntegerValue("-17 + -9 - -1 + -4", -29);
		calculateIntegerValue("-20 * -22 * 13 + +16 - +19", 5717);
		calculateIntegerValue("+1 - -11 - +11 * +21 - -17", -202);
		calculateIntegerValue("8 + 5 - -19", 32);
		calculateIntegerValue("-7 - +16 * 7 * 8", -903);
	}
	
	private void calculateIntegerValue(String strExpression, Integer expectedResult) throws ParseError {
		Value value = parser.parseExpression(strExpression).accept(new ExpressionValueVisitor(valueMapper, errors));
		assertEquals(value.getClass(), IntegerValue.class);
		Integer intValue = ((IntegerValue)value).getValue();
		assertEquals(intValue, expectedResult);
	}
	
	private void calculateBooleanValue(String strExpression, Boolean expectedResult) throws ParseError {
		Value value = parser.parseExpression(strExpression).accept(new ExpressionValueVisitor(valueMapper, errors));
		assertEquals(value.getClass(), BooleanValue.class);
		Boolean boolValue = ((BooleanValue)value).getValue();
		assertEquals(boolValue, expectedResult);
	}
}