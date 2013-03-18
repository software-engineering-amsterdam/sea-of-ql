package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.literal.*;
import org.uva.sea.ql.ast.expression.operators.logical.*;
import org.uva.sea.ql.ast.expression.operators.numeric.*;
import org.uva.sea.ql.ast.expression.operators.relational.*;
import org.uva.sea.ql.ast.statement.*;
import org.uva.sea.ql.eval.*;
import org.uva.sea.ql.parser.jacc.JACCParser;
import org.uva.sea.ql.typechecker.CheckExpression;
import org.uva.sea.ql.typechecker.CheckStatement;
import org.uva.sea.ql.typechecker.Message;
import org.uva.sea.ql.typechecker.TypeEnvironment;

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
		assertTrue(CheckExpression.check((Expression) parser.parse("(1 - 2 / 4) * 4"),       new TypeEnvironment(), new ArrayList<Message>()));
		assertTrue(CheckExpression.check((Expression) parser.parse("true && false || true"), new TypeEnvironment(), new ArrayList<Message>()));
		assertTrue(CheckExpression.check((Expression) parser.parse("(1 - 2 / 4) >= 4"),      new TypeEnvironment(), new ArrayList<Message>()));
		assertTrue(CheckExpression.check((Expression) parser.parse("abc"),                   new TypeEnvironment(), new ArrayList<Message>()));
		assertTrue(CheckExpression.check((Expression) parser.parse("\"abc\""),               new TypeEnvironment(), new ArrayList<Message>()));
		assertTrue(CheckExpression.check((Expression) parser.parse("123"),                   new TypeEnvironment(), new ArrayList<Message>()));
	}
	
	@Test
	public void testStatementTypes() throws Exception {
		assertTrue(CheckStatement.check((Statement)parser.parse("form a { hasSoldHouse:\"Did you sell a house in 2010?\" boolean }"), new TypeEnvironment(), new ArrayList<Message>()));
		assertTrue(CheckStatement.check((Statement)parser.parse("form a { hasSoldHouse:\"Did you sell a house in 2010?\" boolean\n hasBoughtHouse: \"Did you by a house in 2010?\" integer }"), new TypeEnvironment(), new ArrayList<Message>()));
		assertTrue(CheckStatement.check((Statement)parser.parse("form a { hasSoldHouse:\"Did you sell a house in 2010?\" boolean\n hasBoughtHouse: \"Did you by a house in 2010?\" boolean(hasSoldHouse) }"), new TypeEnvironment(), new ArrayList<Message>()));

		assertTrue(CheckStatement.check((Statement) parser.parse(
				"form a { \n" +
				"	hasSoldHouse:\"Did you sell a house in 2010?\" boolean\n" +
				"	hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n" +
				"	if (hasSoldHouse) {\n" +
				"		sellingPrice: \"Price the house was sold for:\" integer(1+2)\n" +
				"	}\n" +
				"}"), new TypeEnvironment(), new ArrayList<Message>()));
	}
	
	@Test
	public void testEvaluations() throws Exception {
		assertEquals(((Expression)parser.parse("(1+2)*5-8")).accept(new Eval(new ValueEnvironment())), new IntegerValue(7));
		assertEquals(((Expression)parser.parse("100")).accept(new Eval(new ValueEnvironment())), new IntegerValue(100));
	}
	
}
