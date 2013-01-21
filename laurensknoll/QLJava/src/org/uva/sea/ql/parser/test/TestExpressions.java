package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.And;
import org.uva.sea.ql.ast.expr.Div;
import org.uva.sea.ql.ast.expr.Eq;
import org.uva.sea.ql.ast.expr.GEq;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.NEq;
import org.uva.sea.ql.ast.expr.Neg;
import org.uva.sea.ql.ast.expr.Not;
import org.uva.sea.ql.ast.expr.Or;
import org.uva.sea.ql.ast.expr.Pos;
import org.uva.sea.ql.ast.expr.Sub;
import org.uva.sea.ql.parser.antlr.ExprParser;

@RunWith(Parameterized.class)
public class TestExpressions {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> parserList = new ArrayList<Object[]>();
		parserList.add(new Object[] { new ExprParser() });
		return parserList;
	}

	public TestExpressions(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testAdds() throws ParseError {
		assertEquals(Add.class, parser.parse("a + b").getClass());
		assertEquals(Add.class, parser.parse("a + b + c").getClass());
		assertEquals(Add.class, parser.parse("(a + b + c)").getClass());
		assertEquals(Add.class, parser.parse("a + (b + c)").getClass());
		assertEquals(Add.class, parser.parse("(a + b) + c").getClass());
		assertEquals(Add.class, parser.parse("(a + b)").getClass());
		assertEquals(Add.class, parser.parse("a + b * c").getClass());
		assertEquals(Add.class, parser.parse("a * b + c").getClass());
	}

	@Test
	public void testAnds() throws ParseError {
		assertEquals(And.class, parser.parse("a && b").getClass());
		assertEquals(And.class, parser.parse("a && (b && c)").getClass());
		assertEquals(And.class, parser.parse("(a && b) && c").getClass());
		assertEquals(And.class, parser.parse("(a || b) && c").getClass());
	}

	@Test
	public void testDivs() throws ParseError {
		assertEquals(Div.class, parser.parse("a / b").getClass());
		assertEquals(Div.class, parser.parse("(a * b) / c").getClass());
	}

	@Test
	public void testEquals() throws ParseError {
		assertEquals(Eq.class, parser.parse("a == b").getClass());
		assertEquals(Eq.class, parser.parse("(a || b) == c").getClass());
	}

	@Test
	public void testGreaterEquals() throws ParseError {
		assertEquals(GEq.class, parser.parse("(a >= b)").getClass());
		assertEquals(GEq.class, parser.parse("a >= b").getClass());
		assertEquals(GEq.class, parser.parse("a >= b + c").getClass());
	}

	@Test
	public void testGreatherThans() throws ParseError {
		assertEquals(GT.class, parser.parse("a + b > c").getClass());
		assertEquals(GT.class, parser.parse("a > b + c").getClass());
	}

	@Test
	public void testLessEquals() throws ParseError {
		assertEquals(LEq.class, parser.parse("(a <= b)").getClass());
		assertEquals(LEq.class, parser.parse("a <= b").getClass());
		assertEquals(LEq.class, parser.parse("a <= b + c").getClass());
	}

	@Test
	public void testLessThans() throws ParseError {
		assertEquals(LT.class, parser.parse("a < b").getClass());
		assertEquals(LT.class, parser.parse("a < b + c").getClass());
		assertEquals(LT.class, parser.parse("a < (b * c)").getClass());
		assertEquals(LT.class, parser.parse("(a * b) < c").getClass());
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(Mul.class, parser.parse("a * b").getClass());
		assertEquals(Mul.class, parser.parse("a * b * c").getClass());
		assertEquals(Mul.class, parser.parse("a * (b * c)").getClass());
		assertEquals(Mul.class, parser.parse("(a * b) * c").getClass());
		assertEquals(Mul.class, parser.parse("(a * b)").getClass());
		assertEquals(Mul.class, parser.parse("(a + b) * c").getClass());
		assertEquals(Mul.class, parser.parse("a * (b + c)").getClass());
	}

	@Test
	public void testNegatives() throws ParseError {
		assertEquals(Neg.class, parser.parse("-a").getClass());
		assertEquals(Neg.class, parser.parse("-123.50").getClass());
		assertEquals(Neg.class, parser.parse("-10").getClass());
	}

	@Test
	public void testOrs() throws ParseError {
		assertEquals(Or.class, parser.parse("a || b").getClass());
		assertEquals(Or.class, parser.parse("a || (b || c)").getClass());
		assertEquals(Or.class, parser.parse("(a || b) || c").getClass());
		assertEquals(Or.class, parser.parse("(a && b) || c").getClass());
	}

	@Test
	public void testPositives() throws ParseError {
		assertEquals(Pos.class, parser.parse("+a").getClass());
		assertEquals(Pos.class, parser.parse("+123.50").getClass());
		assertEquals(Pos.class, parser.parse("+10").getClass());
	}

	@Test
	public void testNotEquals() throws ParseError {
		assertEquals(NEq.class, parser.parse("a != b").getClass());
		assertEquals(NEq.class, parser.parse("(a || b) != c").getClass());
	}

	@Test
	public void testNots() throws ParseError {
		assertEquals(Not.class, parser.parse("!a").getClass());
	}

	@Test
	public void testSubs() throws ParseError {
		assertEquals(Sub.class, parser.parse("a - b").getClass());
		assertEquals(Sub.class, parser.parse("a - b - c").getClass());
		assertEquals(Sub.class, parser.parse("(a - b - c)").getClass());
		assertEquals(Sub.class, parser.parse("a - (b - c)").getClass());
		assertEquals(Sub.class, parser.parse("(a - b) - c").getClass());
		assertEquals(Sub.class, parser.parse("(a - b)").getClass());
		assertEquals(Sub.class, parser.parse("a - b * c").getClass());
		assertEquals(Sub.class, parser.parse("a * b - c").getClass());
	}

}
