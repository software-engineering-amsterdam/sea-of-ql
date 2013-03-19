package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.uva.sea.ql.ast.Identifier;
import org.uva.sea.ql.ast.literal.*;
import org.uva.sea.ql.ast.operators.logical.*;
import org.uva.sea.ql.ast.operators.numeric.*;
import org.uva.sea.ql.ast.operators.relational.*;
import org.uva.sea.ql.parser.jacc.JACCParser;

public class TestExpressions {

	private IParse parser;
	
	public TestExpressions() {
		this.parser = new JACCParser();
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
		
		assertEquals(parser.parse("1.0").getClass(), MoneyLiteral.class);
		assertEquals(parser.parse("123.456").getClass(), MoneyLiteral.class);
	}
	
	@Test
	public void testStrings() throws ParseError {
		assertEquals(parser.parse("\"abc\"").getClass(), StringLiteral.class);
		assertEquals(parser.parse("\"s12f}+{a()\"").getClass(), StringLiteral.class);
		assertEquals(parser.parse("\"(a > b) && (b > c)\"").getClass(), StringLiteral.class);
	}
	
	@Test
	public void testBoolLiterals() throws ParseError {
		assertEquals(parser.parse("true").getClass(), BooleanLiteral.class);
		assertEquals(parser.parse("false").getClass(), BooleanLiteral.class);
	}
	
}
