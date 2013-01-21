package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expressions.binaryExpr.*;
import org.uva.sea.ql.ast.expressions.unaryExpr.*;
import org.uva.sea.ql.ast.expressions.*;
import org.uva.sea.ql.ast.statements.*;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

@RunWith(Parameterized.class)
public class TestExpressions {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
	  return Arrays.asList( 
			  new Object[][] {{new ANTLRParser()}}
			 );
	}

	
	public TestExpressions(IParse parser) {
		this.parser = parser;
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
		assertEquals(parser.parseExpr("0").getClass(), Int.class);
		assertEquals(parser.parseExpr("1223").getClass(), Int.class);
		assertEquals(parser.parseExpr("234234234").getClass(), Int.class);
	}
	
	@Test
	 public void testBooleans() throws ParseError {
	 	assertEquals(parser.parseExpr("true").getClass(), Bool.class);
	 	assertEquals(parser.parseExpr("false").getClass(), Bool.class);
	 }
	
	@Test
	public void testQuestion() throws ParseError {
	 	assertEquals(parser.parseForm("hasSoldHouse: \"Did you sell a house in 2010?\" boolean").getClass(), Question.class);
	 	assertEquals(parser.parseForm("privateDebt: \"Private debts for the sold house:\" money").getClass(), Question.class);
	}
}
