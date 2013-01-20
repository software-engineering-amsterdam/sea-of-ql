package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expr.type.BoolExprType;
import org.uva.sea.ql.ast.expr.type.IdentExprType;
import org.uva.sea.ql.ast.expr.type.IntExprType;
import org.uva.sea.ql.ast.expr.type.MoneyExprType;
import org.uva.sea.ql.ast.expr.type.StringExprType;
import org.uva.sea.ql.parser.antlr.ExprParser;

@RunWith(Parameterized.class)
public class TestExpressionTypes {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> parserList = new ArrayList<Object[]>();
		parserList.add(new Object[] { new ExprParser() });
		return parserList;
	}

	public TestExpressionTypes(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testBools() throws ParseError {
		assertEquals(BoolExprType.class, parser.parse("true").getClass());
		assertEquals(BoolExprType.class, parser.parse("false").getClass());
	}

	@Test
	public void testIdents() throws ParseError {
		assertEquals(IdentExprType.class, parser.parse("a").getClass());
		assertEquals(IdentExprType.class, parser.parse("abc").getClass());
		assertEquals(IdentExprType.class, parser.parse("ABC").getClass());
		assertEquals(IdentExprType.class, parser.parse("ABCDEF").getClass());
		assertEquals(IdentExprType.class, parser.parse("abc2323").getClass());
		assertEquals(IdentExprType.class, parser.parse("a2bc232").getClass());
		assertEquals(IdentExprType.class, parser.parse("a2bc232aa").getClass());
	}

	@Test
	public void testInts() throws ParseError {
		assertEquals(IntExprType.class, parser.parse("0").getClass());
		assertEquals(IntExprType.class, parser.parse("1223").getClass());
		assertEquals(IntExprType.class, parser.parse("234234234").getClass());
	}

	@Test
	public void testMoneys() throws ParseError {
		assertEquals(MoneyExprType.class, parser.parse("100.00").getClass());
		assertEquals(MoneyExprType.class, parser.parse("1.00").getClass());
		assertEquals(MoneyExprType.class, parser.parse("0.50").getClass());
	}

	@Test
	public void testStrings() throws ParseError {
		final String test1 = "\"A short string\"";
		assertEquals(StringExprType.class, parser.parse(test1).getClass());
	}

}
