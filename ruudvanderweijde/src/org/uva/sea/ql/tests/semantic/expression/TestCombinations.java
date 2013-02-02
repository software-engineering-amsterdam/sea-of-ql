package org.uva.sea.ql.tests.semantic.expression;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.tests.IParse;
import org.uva.sea.ql.visitor.ExpressionVisitor;

@RunWith(Parameterized.class)
public class TestCombinations {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		Object[][] data = new Object[][] { new Object[] {new ANTLRParser()} };
		return Arrays.asList(data);
	}
	public static HashMap<Ident, Type> exprMap = new HashMap<Ident, Type>();
	public static ArrayList<String> errors = new ArrayList<String>();

	
	public TestCombinations(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testInvalidCombinations() throws ParseError {
		assertFalse(parser.parseExpression("25 - 19 || true + 12").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("9 < 22 || 16 < 25 >= 14").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("4 > 17 == 24 == false + 25").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("23 / 23 && false <= 4").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("false >= true <= 9 && 1").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("6 <= 9 != 3 != 18 < 15").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("9 + 1 == true").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("23 != 9 < 23 > 11").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("23 || false < 2").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("6 || 6 - 21 / true").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("18 + 22 >= 7 == 24").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("false >= 12 >= false == 0 || 15").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("5 && 1 * 18 - 13 != 11").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("false != 24 * 18 / 21").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("21 && 2 - 13").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("18 > 10 <= 10 < true").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("false <= 24 / 22 < 3").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("true != false * 3").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("4 && 19 > 22 < 19 || true || 24 >= 17").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("7 && true * true < 4 * 12").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("23 * true - false / fals").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("11 / false != 6 - 1 != 18").accept(new ExpressionVisitor(exprMap, errors)));
		assertFalse(parser.parseExpression("7 / 2 || true || 19 || 0").accept(new ExpressionVisitor(exprMap, errors)));
	}

	@Test
	public void testBoolExpr() throws ParseError {
		assertTrue(parser.parseExpression("!false || true == !false").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("true || true == !true || !true && !false").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("!false && false && !true == !false == true && !false").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("!true || false || !true != !false && true").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("!false == !false != !true && !true && !false || !true").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("true == !true || true != true").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("true == !false || true != false").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("false != false != !false && false != !true || !true && true && true").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("true != !true").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("false && false != false && true && !false || false").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("!true || false == false || !true").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("true && false && !false != true == !false && !false == false").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("!true || true != !true").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("!false || !true == true").accept(new ExpressionVisitor(exprMap, errors)));
	}
	
	@Test
	public void testRelExpr() throws ParseError {
		assertTrue(parser.parseExpression("+19 / -7 >= +1 - 21").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("9 <= +7 / -11 * +18").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("+21 > -22").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("+13 >= -4 * +2 - -8 * 20").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("+15 > -21 * -18 / -8 / +10").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("2 <= -15 - -25 - -14").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("+7 < +2").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("+24 * 20 <= +0 - -23").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("2 < 16").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("-24 * -20 / -1 - -22 - -13 < +20").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("-13 - +7 >= -10 * +5 * -24").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("+25 + 12 / 24 > 24").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("+3 - 6 / 25").accept(new ExpressionVisitor(exprMap, errors)));
		assertTrue(parser.parseExpression("-11 / -24 - +15 / +24 < +19 - +11").accept(new ExpressionVisitor(exprMap, errors)));
	}

}