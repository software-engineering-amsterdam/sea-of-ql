package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.data.*;
import org.uva.sea.ql.ast.operators.logical.*;
import org.uva.sea.ql.ast.operators.numeric.*;
import org.uva.sea.ql.ast.operators.relational.*;
import org.uva.sea.ql.parser.jacc.JACCParser;

@RunWith(Parameterized.class)
public class TestExpressions {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		Object[][] parsers = { {new JACCParser()} };
		return Arrays.asList(parsers);
	}

	
	public TestExpressions(IParse parser) {
		this.parser = parser;
	}

	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.parse("a + b").getClass(), Add.class);
		assertEquals(parser.parse("a + b + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.parse("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.parse("(a + b) + c").getClass(), Add.class);
		assertEquals(parser.parse("(a + b)").getClass(), Add.class);
		assertEquals(parser.parse("a + b * c").getClass(), Add.class);
		assertEquals(parser.parse("a * b + c").getClass(), Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.parse("a * b").getClass(), Mul.class);
		assertEquals(parser.parse("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parse("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parse("a * (b + c)").getClass(), Mul.class);
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.parse("a < b").getClass(), LT.class);
		assertEquals(parser.parse("a < b + c").getClass(), LT.class);
		assertEquals(parser.parse("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parse("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parse("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parse("a + b > c").getClass(), GT.class);
		assertEquals(parser.parse("a > b + c").getClass(), GT.class);
	}
	
	@Test
	public void testBools() throws ParseError {
		assertEquals(parser.parse("!b").getClass(), Not.class);
		assertEquals(parser.parse("a && b").getClass(), And.class);
		assertEquals(parser.parse("a > b && b > c").getClass(), And.class);
		assertEquals(parser.parse("(a > b) && (b > c)").getClass(), And.class);
	}

	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parse("a").getClass(), Ident.class);
		assertEquals(parser.parse("abc").getClass(), Ident.class);
		assertEquals(parser.parse("ABC").getClass(), Ident.class);
		assertEquals(parser.parse("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parse("abc2323").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parse("a2bc232aa").getClass(), Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parse("0").getClass(), Int.class);
		assertEquals(parser.parse("1223").getClass(), Int.class);
		assertEquals(parser.parse("234234234").getClass(), Int.class);
	}
	
	@Test
	public void testStrings() throws ParseError {
		assertEquals(parser.parse("\"abc\"").getClass(), Str.class);
		assertEquals(parser.parse("\"s12f}+{a()\"").getClass(), Str.class);
		assertEquals(parser.parse("\"(a > b) && (b > c)\"").getClass(), Str.class);
	}
	
}
