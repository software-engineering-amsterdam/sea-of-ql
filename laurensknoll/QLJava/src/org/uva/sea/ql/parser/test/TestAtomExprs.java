package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expr.atom.Bool;
import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.expr.atom.Int;
import org.uva.sea.ql.ast.expr.atom.Money;
import org.uva.sea.ql.parser.antlr.ExprParser;

@RunWith(Parameterized.class)
public class TestAtomExprs {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> parserList = new ArrayList<Object[]>();
		parserList.add(new Object[] { new ExprParser() });
		return parserList;
	}

	public TestAtomExprs(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testBools() throws ParseError {
		assertEquals(Bool.class, parser.parse("true").getClass());
		assertEquals(Bool.class, parser.parse("false").getClass());
	}

	@Test
	public void testIdents() throws ParseError {
		assertEquals(Ident.class, parser.parse("a").getClass());
		assertEquals(Ident.class, parser.parse("abc").getClass());
		assertEquals(Ident.class, parser.parse("ABC").getClass());
		assertEquals(Ident.class, parser.parse("ABCDEF").getClass());
		assertEquals(Ident.class, parser.parse("abc2323").getClass());
		assertEquals(Ident.class, parser.parse("a2bc232").getClass());
		assertEquals(Ident.class, parser.parse("a2bc232aa").getClass());
	}

	@Test
	public void testInts() throws ParseError {
		assertEquals(Int.class, parser.parse("0").getClass());
		assertEquals(Int.class, parser.parse("1223").getClass());
		assertEquals(Int.class, parser.parse("234234234").getClass());
	}

	@Test
	public void testMoneys() throws ParseError {
		assertEquals(Money.class, parser.parse("100.00").getClass());
		assertEquals(Money.class, parser.parse("1.00").getClass());
		assertEquals(Money.class, parser.parse("0.50").getClass());
	}

	@Test
	public void testStrings() throws ParseError {
		final String test1 = "\"A short string\"";
		assertEquals(org.uva.sea.ql.ast.expr.atom.String.class,
				parser.parse(test1).getClass());
	}

}
