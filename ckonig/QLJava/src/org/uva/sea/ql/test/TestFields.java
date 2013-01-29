package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.uva.sea.ql.ast.elements.Ident;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.literal.IntLiteral;
import org.uva.sea.ql.ast.literal.StringLiteral;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.parser.ParseError;

public class TestFields extends TestExpressions {
	@Test
	public void testIds() throws ParseError {
		Class<?> c = Ident.class;
		testId("a", c);
		testId("aBC", c);
		testId("bBCdEF", c);
		testId("abc2303", c);
		testId("u32bcj2a", c);
	}

	private void testId(String id, Class<?> c) throws ParseError {
		Expr e = parser.parse(id);
		assertNotNull("result was null", e);
		assertEquals(c, e.getClass());
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(IntLiteral.class, parser.parse("0").getClass());
		assertEquals(IntLiteral.class, parser.parse("1223").getClass());
		assertEquals(IntLiteral.class, parser.parse("234234234").getClass());
	}

	@Test
	public void testString() throws ParseError {
		for (String s : getTestStrings()) {
			testString(s, false);
		}
	}

	@Test
	public void testStringValues() throws ParseError {
		for (String s : getTestStrings()) {
			testString(s, true);
		}

	}

	private String[] getTestStrings() {
		String[] ret = { "\"a\"", "\"1223\"", "\"2342 34234\"", "\"aBc\"",
				"\"abc 2323\"", "\"a2bc232aa\"" };
		return ret;
	}

	private void testString(String in, boolean testValue) throws ParseError {
		Expr e = parser.parse(in);
		assertEquals(StringLiteral.class, e.getClass());
		if (testValue) {
			StringLiteral s = (StringLiteral) e;
			assertEquals(in.replace("\"", ""), s.getValue());
		}
	}

	@Test
	public void testInlineComment() throws ParseError {
		Expr e = parser.parse("//this is a comment\n");
		assertEquals(null, e);
	}

	@Test
	public void testComment() throws ParseError {
		Expr e = parser.parse("/* this is a comment /*");
		assertEquals(null, e);
	}

	@Test
	public void testBoolean() throws ParseError {
		Expr e = parser.parse("boolean");
		assertNotNull(e);
		assertEquals(BooleanType.class, e.getClass());
	}

	@Test
	public void testMoney() throws ParseError {
		Expr e = parser.parse("money");
		assertNotNull(e);
		assertEquals(Money.class, e.getClass());
	}

	@Test
	public void testMoneyWithValue() throws ParseError {
		Expr e = parser.parse("money(50)");
		assertNotNull(e);
		assertEquals(Money.class, e.getClass());
	}

	@Test
	public void testMoneyWithAdd() throws ParseError {
		Expr e = parser.parse("money(50 + 50)");
		assertNotNull(e);
		assertEquals(Money.class, e.getClass());
	}
}
