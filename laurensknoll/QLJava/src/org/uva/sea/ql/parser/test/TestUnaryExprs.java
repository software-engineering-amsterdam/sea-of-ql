package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.parser.antlr.ExprParser;

@RunWith(Parameterized.class)
public class TestUnaryExprs {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> parserList = new ArrayList<Object[]>();
		parserList.add(new Object[] { new ExprParser() });
		return parserList;
	}

	public TestUnaryExprs(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testNegatives() throws ParseError {
		assertEquals(Neg.class, parser.parse("-a").getClass());
		assertEquals(Neg.class, parser.parse("-123.50").getClass());
		assertEquals(Neg.class, parser.parse("-10").getClass());
	}

	@Test
	public void testPositives() throws ParseError {
		assertEquals(Pos.class, parser.parse("+a").getClass());
		assertEquals(Pos.class, parser.parse("+123.50").getClass());
		assertEquals(Pos.class, parser.parse("+10").getClass());
	}

	@Test
	public void testNots() throws ParseError {
		assertEquals(Not.class, parser.parse("!a").getClass());
	}

}
