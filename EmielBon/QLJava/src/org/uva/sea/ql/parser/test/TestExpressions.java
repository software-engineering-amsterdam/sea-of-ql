package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.literal.*;
import org.uva.sea.ql.ast.operators.logical.*;
import org.uva.sea.ql.ast.operators.numeric.*;
import org.uva.sea.ql.ast.operators.relational.*;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.typechecker.CheckExpression;
import org.uva.sea.ql.typechecker.Message;

public class TestExpressions {

	private JACCParser parser;
	
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
	}
	
	@Test
	public void testStrings() throws ParseError {
		assertEquals(parser.parse("\"abc\"").getClass(), StringLiteral.class);
		assertEquals(parser.parse("\"s12f}+{a()\"").getClass(), StringLiteral.class);
		assertEquals(parser.parse("\"(a > b) && (b > c)\"").getClass(), StringLiteral.class);
	}
	
	@Test
	public void testQuestions() throws ParseError {
		assertEquals(parser.parse("x : \"abc\" boolean").getClass(), Question.class);
		assertEquals(parser.parse("dasx : \"452abc\" boolean").getClass(), Question.class);
		assertEquals(parser.parse("hasSoldHouse:\"Did you sell a house in 2010?\" boolean").getClass(), Question.class);
		assertEquals(parser.parse("sellingPrice:\"Price the house was sold for:\" integer(1000+10)").getClass(), ComputedQuestion.class);
	}
	
	@Test
	public void testBoolLiterals() throws ParseError {
		assertEquals(parser.parse("true").getClass(), BooleanLiteral.class);
		assertEquals(parser.parse("false").getClass(), BooleanLiteral.class);
	}
	
	@Test
	public void testConditionals() throws ParseError {
		assertEquals(parser.parse("if (bla) { x : \"X?\" boolean }").getClass(), IfBlock.class);
	}
	
	@Test
	public void testForms() throws ParseError {
		assertEquals(parser.parse("form a { hasSoldHouse:\"Did you sell a house in 2010?\" boolean }").getClass(), Form.class);
		assertEquals(parser.parse("form a { hasSoldHouse:\"Did you sell a house in 2010?\" boolean\n hasBoughtHouse: \"Did you by a house in 2010?\" integer }").getClass(), Form.class);
		assertEquals(parser.parse("\n" +
				"form a { \n" +
				"	hasSoldHouse:\"Did you sell a house in 2010?\" boolean\n" +
				"	hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n" +
				"	if (hasSoldHouse) {\n" +
				"		sellingPrice: \"Price the house was sold for:\" integer(1+2)\n" +
				"	}\n" +
				"}").getClass(), Form.class);
	}
	
	@Test
	public void testExpressionTypes() throws Exception {
		assertTrue(CheckExpression.check((Expression) parser.parse("(1 - 2 / 4) * 4"),       new HashMap<Identifier, Type>(), new ArrayList<Message>()));
		assertTrue(CheckExpression.check((Expression) parser.parse("true && false || true"), new HashMap<Identifier, Type>(), new ArrayList<Message>()));
		assertTrue(CheckExpression.check((Expression) parser.parse("(1 - 2 / 4) >= 4"),      new HashMap<Identifier, Type>(), new ArrayList<Message>()));
		assertTrue(CheckExpression.check((Expression) parser.parse("abc"),                   new HashMap<Identifier, Type>(), new ArrayList<Message>()));
		assertTrue(CheckExpression.check((Expression) parser.parse("\"abc\""),               new HashMap<Identifier, Type>(), new ArrayList<Message>()));
		assertTrue(CheckExpression.check((Expression) parser.parse("123"),                   new HashMap<Identifier, Type>(), new ArrayList<Message>()));
	}
	
}
