package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expressions.Addition;
import org.uva.sea.ql.ast.expressions.GreaterThan;
import org.uva.sea.ql.ast.expressions.Identifier;
import org.uva.sea.ql.ast.expressions.IntegerLiteral;
import org.uva.sea.ql.ast.expressions.LessThan;
import org.uva.sea.ql.ast.expressions.LessThanOrEquals;
import org.uva.sea.ql.ast.expressions.MoneyLiteral;
import org.uva.sea.ql.ast.expressions.Multiplication;
import org.uva.sea.ql.ast.expressions.Subtraction;
import org.uva.sea.ql.parser.IParser;
import org.uva.sea.ql.parser.JACCParser;
import org.uva.sea.ql.parser.ParseError;

public class TestExpressions {

	private IParser parser;
	
	public TestExpressions() {
		this.parser = new JACCParser();
	}

	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.parse("a + b").getClass(), Addition.class);
		assertEquals(parser.parse("a + b + c").getClass(), Addition.class);
		assertEquals(parser.parse("(a + b + c)").getClass(), Addition.class);
		assertEquals(parser.parse("a + (b + c)").getClass(), Addition.class);
		assertEquals(parser.parse("(a + b) + c").getClass(), Addition.class);
		assertEquals(parser.parse("(a + b)").getClass(), Addition.class);
		assertEquals(parser.parse("a + b * c").getClass(), Addition.class);
		assertEquals(parser.parse("a * b + c").getClass(), Addition.class);
		assertEquals(parser.parse("1+1").getClass(), Addition.class);
	}
	
	@Test
	public void testSubs() throws ParseError {
		assertEquals(parser.parse("a - b").getClass(), Subtraction.class);
		assertEquals(parser.parse("a - b - c").getClass(), Subtraction.class);
		assertEquals(parser.parse("(a - b - c)").getClass(), Subtraction.class);
		assertEquals(parser.parse("a - (b - c)").getClass(), Subtraction.class);
		assertEquals(parser.parse("(a - b) - c").getClass(), Subtraction.class);
		assertEquals(parser.parse("(a - b)").getClass(), Subtraction.class);
		assertEquals(parser.parse("a - b * c").getClass(), Subtraction.class);
		assertEquals(parser.parse("a * b - c").getClass(), Subtraction.class);
		assertEquals(parser.parse("1-1").getClass(), Subtraction.class);
	}
	
	@Test
	public void testNumbers() throws ParseError {
		assertEquals(parser.parse("3.14E10").getClass(), MoneyLiteral.class);
		assertEquals(parser.parse("3.44E-10").getClass(), MoneyLiteral.class);
		assertEquals(parser.parse("5.14E+20").getClass(), MoneyLiteral.class);
		assertEquals(parser.parse("3511111111111111111111111111111111111111111111111111112222211111111111111111111111111111111111111111").getClass(), MoneyLiteral.class);
		assertEquals(parser.parse("5.0").getClass(), MoneyLiteral.class);
		assertEquals(parser.parse(new Long(Long.MAX_VALUE).toString() + "1").getClass(), MoneyLiteral.class);
		assertEquals(parser.parse("5").getClass(), IntegerLiteral.class);
		assertEquals(parser.parse("4123213").getClass(), IntegerLiteral.class);		
	}
	
	@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.parse("a * b").getClass(), Multiplication.class);
		assertEquals(parser.parse("a * b * c").getClass(), Multiplication.class);
		assertEquals(parser.parse("a * (b * c)").getClass(), Multiplication.class);
		assertEquals(parser.parse("(a * b) * c").getClass(), Multiplication.class);
		assertEquals(parser.parse("(a * b)").getClass(), Multiplication.class);
		assertEquals(parser.parse("(a + b) * c").getClass(), Multiplication.class);
		assertEquals(parser.parse("a * (b + c)").getClass(), Multiplication.class);
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.parse("a < b").getClass(), LessThan.class);
		assertEquals(parser.parse("a < b + c").getClass(), LessThan.class);
		assertEquals(parser.parse("a < (b * c)").getClass(), LessThan.class);
		assertEquals(parser.parse("(a * b) < c").getClass(), LessThan.class);
		assertEquals(parser.parse("(a <= b)").getClass(), LessThanOrEquals.class);
		assertEquals(parser.parse("a + b > c").getClass(), GreaterThan.class);
		assertEquals(parser.parse("a > b + c").getClass(), GreaterThan.class);
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parse("a").getClass(), Identifier.class);
		assertEquals(parser.parse("abc").getClass(), Identifier.class);
		assertEquals(parser.parse("ABC").getClass(), Identifier.class);
		assertEquals(parser.parse("ABCDEF").getClass(), Identifier.class);
		assertEquals(parser.parse("abc2323").getClass(), Identifier.class);
		assertEquals(parser.parse("a2bc232").getClass(), Identifier.class);
		assertEquals(parser.parse("a2bc232aa").getClass(), Identifier.class);
		assertEquals(parser.parse("___a2bc232").getClass(), Identifier.class);
		assertEquals(parser.parse("___a2bc232aa").getClass(), Identifier.class);
		assertEquals(parser.parse("_a2bc232").getClass(), Identifier.class);
		assertEquals(parser.parse("_").getClass(), Identifier.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parse("0").getClass(), IntegerLiteral.class);
		assertEquals(parser.parse("1223").getClass(), IntegerLiteral.class);
		assertEquals(parser.parse("234234234").getClass(), IntegerLiteral.class);
	}
	
}
