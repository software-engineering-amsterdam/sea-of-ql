package org.uva.sea.ql.parser.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.GT;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.IntLiteral;
import org.uva.sea.ql.ast.LEq;
import org.uva.sea.ql.ast.LT;
import org.uva.sea.ql.ast.Mul;

public class TestExpressions extends TestCase {

	static final private IParse parser = new ANTLRParser();

	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.expr("a + b").getClass(), Add.class);
		assertEquals(parser.expr("a + b + c").getClass(), Add.class);
		assertEquals(parser.expr("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.expr("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.expr("(a + b) + c").getClass(), Add.class);
		assertEquals(parser.expr("(a + b)").getClass(), Add.class);
		assertEquals(parser.expr("a + b * c").getClass(), Add.class);
		assertEquals(parser.expr("a * b + c").getClass(), Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.expr("a * b").getClass(), Mul.class);
		assertEquals(parser.expr("a * b * c").getClass(), Mul.class);
		assertEquals(parser.expr("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.expr("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.expr("(a * b)").getClass(), Mul.class);
		assertEquals(parser.expr("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.expr("a * (b + c)").getClass(), Mul.class);
	}

	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.expr("a < b").getClass(), LT.class);
		assertEquals(parser.expr("a < b + c").getClass(), LT.class);
		assertEquals(parser.expr("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.expr("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.expr("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.expr("a + b > c").getClass(), GT.class);
		assertEquals(parser.expr("a > b + c").getClass(), GT.class);
	}

	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.expr("a").getClass(), Ident.class);
		assertEquals(parser.expr("abc").getClass(), Ident.class);
		assertEquals(parser.expr("ABC").getClass(), Ident.class);
		assertEquals(parser.expr("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.expr("abc2323").getClass(), Ident.class);
		assertEquals(parser.expr("a2bc232").getClass(), Ident.class);
		assertEquals(parser.expr("a2bc232aa").getClass(), Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.expr("0").getClass(), IntLiteral.class);
		assertEquals(parser.expr("1223").getClass(), IntLiteral.class);
		assertEquals(parser.expr("234234234").getClass(), IntLiteral.class);
	}
}
