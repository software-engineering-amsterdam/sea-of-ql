package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.expressions.Add;
import org.uva.sea.ql.ast.expressions.GT;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.expressions.Int;
import org.uva.sea.ql.ast.expressions.LEq;
import org.uva.sea.ql.ast.expressions.LT;
import org.uva.sea.ql.ast.expressions.Mul;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestExpressions {

	private IParse parser;

	@Before
	public void setUp() {
		parser = new ANTLRParser();
	}
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(Add.class, parser.parseExpr("a + b").getClass());
		assertEquals(Add.class, parser.parseExpr("a + b + c").getClass());
		assertEquals(Add.class, parser.parseExpr("(a + b + c)").getClass());
		assertEquals(Add.class, parser.parseExpr("a + (b + c)").getClass());
		assertEquals(Add.class, parser.parseExpr("(a + b) + c").getClass());
		assertEquals(Add.class, parser.parseExpr("(a + b)").getClass());
		assertEquals(Add.class, parser.parseExpr("a + b * c").getClass());
		assertEquals(Add.class, parser.parseExpr("a * b + c").getClass());
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(Mul.class, parser.parseExpr("a * b").getClass());
		assertEquals(Mul.class, parser.parseExpr("a * b * c").getClass());
		assertEquals(Mul.class, parser.parseExpr("a * (b * c)").getClass());
		assertEquals(Mul.class, parser.parseExpr("(a * b) * c").getClass());
		assertEquals(Mul.class, parser.parseExpr("(a * b)").getClass());
		assertEquals(Mul.class, parser.parseExpr("(a + b) * c").getClass());
		assertEquals(Mul.class, parser.parseExpr("a * (b + c)").getClass());
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(LT.class, parser.parseExpr("a < b").getClass());
		assertEquals(LT.class, parser.parseExpr("a < b + c").getClass());
		assertEquals(LT.class, parser.parseExpr("a < (b * c)").getClass());
		assertEquals(LT.class, parser.parseExpr("(a * b) < c").getClass());
		assertEquals(LEq.class, parser.parseExpr("(a <= b)").getClass());
		assertEquals(GT.class, parser.parseExpr("a + b > c").getClass());
		assertEquals(GT.class, parser.parseExpr("a > b + c").getClass());
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(Ident.class, parser.parseExpr("a").getClass());
		assertEquals(Ident.class, parser.parseExpr("abc").getClass());
		assertEquals(Ident.class, parser.parseExpr("ABC").getClass());
		assertEquals(Ident.class, parser.parseExpr("ABCDEF").getClass());
		assertEquals(Ident.class, parser.parseExpr("abc2323").getClass());
		assertEquals(Ident.class, parser.parseExpr("a2bc232").getClass());
		assertEquals(Ident.class, parser.parseExpr("a2bc232aa").getClass());
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(Int.class, parser.parseExpr("0").getClass());
		assertEquals(Int.class, parser.parseExpr("1223").getClass());
		assertEquals(Int.class, parser.parseExpr("234234234").getClass());
	}	
	
}
