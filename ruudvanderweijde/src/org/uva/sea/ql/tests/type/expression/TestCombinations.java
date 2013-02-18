package org.uva.sea.ql.tests.type.expression;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.tests.IParse;
import org.uva.sea.ql.visitor.typeCheck.ExpressionTypeVisitor;
import org.uva.sea.ql.visitor.typeCheck.TypeMapper;

public class TestCombinations {
	private final IParse parser = new ANTLRParser();
	public static TypeMapper typeMapper = new TypeMapper();
	public static ArrayList<Message> errors = new ArrayList<Message>();

	@Test
	public void testInvalidCombinations() throws ParseError {
		assertFalse(isValidExpression("25 - 19 || true + 12"));
		assertFalse(isValidExpression("9 < 22 || 16 < 25 >= 14"));
		assertFalse(isValidExpression("4 > 17 == 24 == false + 25"));
		assertFalse(isValidExpression("23 / 23 && false <= 4"));
		assertFalse(isValidExpression("false >= true <= 9 && 1"));
		assertFalse(isValidExpression("6 <= 9 != 3 != 18 < 15"));
		assertFalse(isValidExpression("9 + 1 == true"));
		assertFalse(isValidExpression("23 != 9 < 23 > 11"));
		assertFalse(isValidExpression("23 || false < 2"));
		assertFalse(isValidExpression("6 || 6 - 21 / true"));
		assertFalse(isValidExpression("18 + 22 >= 7 == 24"));
		assertFalse(isValidExpression("false >= 12 >= false == 0 || 15"));
		assertFalse(isValidExpression("5 && 1 * 18 - 13 != 11"));
		assertFalse(isValidExpression("false != 24 * 18 / 21"));
		assertFalse(isValidExpression("21 && 2 - 13"));
		assertFalse(isValidExpression("18 > 10 <= 10 < true"));
		assertFalse(isValidExpression("false <= 24 / 22 < 3"));
		assertFalse(isValidExpression("true != false * 3"));
		assertFalse(isValidExpression("4 && 19 > 22 < 19 || true || 24 >= 17"));
		assertFalse(isValidExpression("7 && true * true < 4 * 12"));
		assertFalse(isValidExpression("23 * true - false / fals"));
		assertFalse(isValidExpression("11 / false != 6 - 1 != 18"));
		assertFalse(isValidExpression("7 / 2 || true || 19 || 0"));
	}

	@Test
	public void testValidBoolExpr() throws ParseError {
		assertTrue(isValidExpression("!false || true == !false"));
		assertTrue(isValidExpression("true || true == !true || !true && !false"));
		assertTrue(isValidExpression("!false && false && !true == !false == true && !false"));
		assertTrue(isValidExpression("!true || false || !true != !false && true"));
		assertTrue(isValidExpression("!false == !false != !true && !true && !false || !true"));
		assertTrue(isValidExpression("true == !true || true != true"));
		assertTrue(isValidExpression("true == !false || true != false"));
		assertTrue(isValidExpression("false != false != !false && false != !true || !true && true && true"));
		assertTrue(isValidExpression("true != !true"));
		assertTrue(isValidExpression("false && false != false && true && !false || false"));
		assertTrue(isValidExpression("!true || false == false || !true"));
		assertTrue(isValidExpression("true && false && !false != true == !false && !false == false"));
		assertTrue(isValidExpression("!true || true != !true"));
		assertTrue(isValidExpression("!false || !true == true"));
	}
	
	@Test
	public void testValidRelExpr() throws ParseError {
		assertTrue(isValidExpression("+19 / -7 >= +1 - 21"));
		assertTrue(isValidExpression("9 <= +7 / -11 * +18"));
		assertTrue(isValidExpression("+21 > -22"));
		assertTrue(isValidExpression("+13 >= -4 * +2 - -8 * 20"));
		assertTrue(isValidExpression("+15 > -21 * -18 / -8 / +10"));
		assertTrue(isValidExpression("2 <= -15 - -25 - -14"));
		assertTrue(isValidExpression("+7 < +2"));
		assertTrue(isValidExpression("+24 * 20 <= +0 - -23"));
		assertTrue(isValidExpression("2 < 16"));
		assertTrue(isValidExpression("-24 * -20 / -1 - -22 - -13 < +20"));
		assertTrue(isValidExpression("-13 - +7 >= -10 * +5 * -24"));
		assertTrue(isValidExpression("+25 + 12 / 24 > 24"));
		assertTrue(isValidExpression("+3 - 6 / 25"));
		assertTrue(isValidExpression("-11 / -24 - +15 / +24 < +19 - +11"));
	}
	
	
	private boolean isValidExpression(String expression) throws ParseError {
		return parser.parseExpression(expression).accept(new ExpressionTypeVisitor(typeMapper, errors));
	}

}