package org.uva.sea.ql.ast.expr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.expr.value.Ident;
import org.uva.sea.ql.ast.expr.value.Int;
import org.uva.sea.ql.error.ParseError;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestExpressions {

	private static final IParse parser = new ANTLRParser();

	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.parseExpression("a + b").getClass(), Add.class);
		assertEquals(parser.parseExpression("a + b + c").getClass(), Add.class);
		assertEquals(parser.parseExpression("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.parseExpression("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.parseExpression("(a + b) + c").getClass(), Add.class);
		assertEquals(parser.parseExpression("(a + b)").getClass(), Add.class);
		assertEquals(parser.parseExpression("a + b * c").getClass(), Add.class);
		assertEquals(parser.parseExpression("a * b + c").getClass(), Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.parseExpression("a * b").getClass(), Mul.class);
		assertEquals(parser.parseExpression("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parseExpression("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parseExpression("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parseExpression("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parseExpression("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parseExpression("a * (b + c)").getClass(), Mul.class);
	}

	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.parseExpression("a < b").getClass(), LT.class);
		assertEquals(parser.parseExpression("a < b + c").getClass(), LT.class);
		assertEquals(parser.parseExpression("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parseExpression("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parseExpression("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parseExpression("a + b > c").getClass(), GT.class);
		assertEquals(parser.parseExpression("a > b + c").getClass(), GT.class);
	}

	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parseExpression("a").getClass(), Ident.class);
		assertEquals(parser.parseExpression("abc").getClass(), Ident.class);
		assertEquals(parser.parseExpression("ABC").getClass(), Ident.class);
		assertEquals(parser.parseExpression("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parseExpression("abc2323").getClass(), Ident.class);
		assertEquals(parser.parseExpression("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parseExpression("a2bc232aa").getClass(), Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parseExpression("0").getClass(), Int.class);
		assertEquals(parser.parseExpression("1223").getClass(), Int.class);
		assertEquals(parser.parseExpression("234234234").getClass(), Int.class);
	}

}
