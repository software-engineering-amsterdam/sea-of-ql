package org.uva.sea.ql.parser.test.syntax;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Int;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.parser.test.ParseError;

public class ExpressionTest extends SyntaxTest {

	@Override
	protected Class<?> parseClass(String src) throws ParseError {
		return getParser().parseExpression(src).getClass();
	}
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(parseClass("a + b"), Add.class);
		assertEquals(parseClass("a + b + c"), Add.class);
		assertEquals(parseClass("(a + b + c)"), Add.class);
		assertEquals(parseClass("a + (b + c)"), Add.class);
		assertEquals(parseClass("(a + b) + c"), Add.class);
		assertEquals(parseClass("(a + b)"), Add.class);
		assertEquals(parseClass("a + b * c"), Add.class);
		assertEquals(parseClass("a * b + c"), Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(parseClass("a * b"), Mul.class);
		assertEquals(parseClass("a * b * c"), Mul.class);
		assertEquals(parseClass("a * (b * c)"), Mul.class);
		assertEquals(parseClass("(a * b) * c"), Mul.class);
		assertEquals(parseClass("(a * b)"), Mul.class);
		assertEquals(parseClass("(a + b) * c"), Mul.class);
		assertEquals(parseClass("a * (b + c)"), Mul.class);
	}

	@Test
	public void testRels() throws ParseError {
		assertEquals(parseClass("a < b"), LT.class);
		assertEquals(parseClass("a < b + c"), LT.class);
		assertEquals(parseClass("a < (b * c)"), LT.class);
		assertEquals(parseClass("(a * b) < c"), LT.class);
		
		assertEquals(parseClass("(a <= b)"), LEq.class);
		assertEquals(parseClass("(a + b <= b)"), LEq.class);
		assertEquals(parseClass("(a <= b * c)"), LEq.class);
		assertEquals(parseClass("(a - b * c <= b)"), LEq.class);
		assertEquals(parseClass("(a <= b)"), LEq.class);
		
		assertEquals(parseClass("a + b == c"), Eq.class);
		assertEquals(parseClass("a == b + c"), Eq.class);
		assertEquals(parseClass("a + b == c"), Eq.class);
		assertEquals(parseClass("a == b + c"), Eq.class);
		
		assertEquals(parseClass("(a >= b)"), GEq.class);
		assertEquals(parseClass("(a + b >= b)"), GEq.class);
		assertEquals(parseClass("(a >= b * c)"), GEq.class);
		assertEquals(parseClass("(a - b * c >= b)"), GEq.class);
		assertEquals(parseClass("(a >= b)"), GEq.class);
		
		assertEquals(parseClass("a + b > c"), GT.class);
		assertEquals(parseClass("a > b + c"), GT.class);
		assertEquals(parseClass("a + b > c"), GT.class);
		assertEquals(parseClass("a > b + c"), GT.class);
	}

	@Test
	public void testBools() throws ParseError {
		assertEquals(parseClass("!b"), Not.class);
		assertEquals(parseClass("!(a == b)"), Not.class);
		assertEquals(parseClass("!(b && c)"), Not.class);
		assertEquals(parseClass("!(d == (e && f) || g)"), Not.class);
		
		assertEquals(parseClass("a && b"), And.class);
		assertEquals(parseClass("a > b && b > c"), And.class);
		assertEquals(parseClass("(a > b) && (b > c)"), And.class);
	}

	@Test
	public void testIds() throws ParseError {
		assertEquals(parseClass("a"), Ident.class);
		assertEquals(parseClass("abc"), Ident.class);
		assertEquals(parseClass("ABC"), Ident.class);
		assertEquals(parseClass("ABCDEF"), Ident.class);
		assertEquals(parseClass("abc2323"), Ident.class);
		assertEquals(parseClass("a2bc232"), Ident.class);
		assertEquals(parseClass("a2bc232aa"), Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parseClass("0"), Int.class);
		assertEquals(parseClass("00000000000000"), Int.class);
		assertEquals(parseClass("1223"), Int.class);
		assertEquals(parseClass("234234234"), Int.class);
		assertEquals(parseClass("000000003"), Int.class);
	}

}
