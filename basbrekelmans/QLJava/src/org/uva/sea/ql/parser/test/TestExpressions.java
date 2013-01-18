package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expressions.*;
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
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parse("0").getClass(), IntegerLiteral.class);
		assertEquals(parser.parse("1223").getClass(), IntegerLiteral.class);
		assertEquals(parser.parse("234234234").getClass(), IntegerLiteral.class);
	}
	
}
