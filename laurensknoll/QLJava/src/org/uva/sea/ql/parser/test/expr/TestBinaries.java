package org.uva.sea.ql.parser.test.expr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.And;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.Eq;
import org.uva.sea.ql.ast.expr.binary.GEq;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.binary.NEq;
import org.uva.sea.ql.ast.expr.binary.Or;
import org.uva.sea.ql.ast.expr.binary.Sub;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class TestBinaries {

	private IParse parser;

	public TestBinaries() {
		this.parser = new Parser();
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
	public void testOrs() throws ParseError {
		assertEquals(Or.class, parser.parse("a || b").getClass());
		assertEquals(Or.class, parser.parse("a || (b || c)").getClass());
		assertEquals(Or.class, parser.parse("(a || b) || c").getClass());
		assertEquals(Or.class, parser.parse("(a && b) || c").getClass());
	}

	@Test
	public void testNotEquals() throws ParseError {
		assertEquals(NEq.class, parser.parse("a != b").getClass());
		assertEquals(NEq.class, parser.parse("(a || b) != c").getClass());
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
