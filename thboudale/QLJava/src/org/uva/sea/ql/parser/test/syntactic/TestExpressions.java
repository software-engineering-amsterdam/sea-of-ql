package org.uva.sea.ql.parser.test.syntactic;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.uva.sea.ql.ast.expressions.binaryExpressions.*;
import org.uva.sea.ql.ast.expressions.unaryExpressions.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.expressions.literals.*;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class TestExpressions {

	private IParse parser;

	public TestExpressions() {
		this.parser = new ANTLRParser();
	}

	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.parseExpr("a + b").getClass(), Add.class);
		assertEquals(parser.parseExpr("a + b + c").getClass(), Add.class);
		assertEquals(parser.parseExpr("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.parseExpr("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.parseExpr("(a + b) + c").getClass(), Add.class);
		assertEquals(parser.parseExpr("(a + b)").getClass(), Add.class);
		assertEquals(parser.parseExpr("a + b * c").getClass(), Add.class);
		assertEquals(parser.parseExpr("a * b + c").getClass(), Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.parseExpr("a * b").getClass(), Mul.class);
		assertEquals(parser.parseExpr("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parseExpr("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parseExpr("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parseExpr("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parseExpr("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parseExpr("a * (b + c)").getClass(), Mul.class);
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.parseExpr("a < b").getClass(), LT.class);
		assertEquals(parser.parseExpr("a < b + c").getClass(), LT.class);
		assertEquals(parser.parseExpr("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parseExpr("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parseExpr("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parseExpr("a + b > c").getClass(), GT.class);
		assertEquals(parser.parseExpr("a > b + c").getClass(), GT.class);
	}
	
	@Test
	public void testBools() throws ParseError {
		assertEquals(parser.parseExpr("!b").getClass(), Not.class);
		assertEquals(parser.parseExpr("a && b").getClass(), And.class);
		assertEquals(parser.parseExpr("a > b && b > c").getClass(), And.class);
		assertEquals(parser.parseExpr("(a > b) && (b > c)").getClass(), And.class);
		assertEquals(parser.parseExpr("a || b").getClass(), Or.class);
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parseExpr("a").getClass(), Ident.class);
		assertEquals(parser.parseExpr("abc").getClass(), Ident.class);
		assertEquals(parser.parseExpr("ABC").getClass(), Ident.class);
		assertEquals(parser.parseExpr("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parseExpr("abc2323").getClass(), Ident.class);
		assertEquals(parser.parseExpr("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parseExpr("a2bc232aa").getClass(), Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parseExpr("0").getClass(), IntLiteral.class);
		assertEquals(parser.parseExpr("1223").getClass(), IntLiteral.class);
		assertEquals(parser.parseExpr("234234234").getClass(), IntLiteral.class);
	}
	
	@Test
	 public void testBooleans() throws ParseError {
	 	assertEquals(parser.parseExpr("true").getClass(), BoolLiteral.class);
	 	assertEquals(parser.parseExpr("false").getClass(), BoolLiteral.class);
	 }
}