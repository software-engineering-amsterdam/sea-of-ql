package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

//import java.util.Arrays;
//import java.util.List;

import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.form.FormText;
import org.uva.sea.ql.ast.operations.Add;
import org.uva.sea.ql.ast.operations.And;
import org.uva.sea.ql.ast.operations.GT;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.operations.LEq;
import org.uva.sea.ql.ast.operations.LT;
import org.uva.sea.ql.ast.operations.Mul;
import org.uva.sea.ql.ast.operations.Not;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.QLString;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

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
		assertEquals(parser.parseExpr("TRUE").getClass(), Bool.class);
	}

	@Test
	public void testStrings() throws ParseError {
		assertEquals(parser.parseExpr("\"'a'\"").getClass(), QLString.class);
		assertEquals(parser.parseExpr("\"TRUE\"").getClass(), QLString.class);
		assertEquals(parser.parseExpr("\"1+4\"").getClass(), QLString.class);
		assertEquals(parser.parseExpr("\"Did you sell a house in 2010?\"").getClass(), QLString.class);
	}

	@Test
	public void testFormElements() throws ParseError {
		assertEquals(parser.parseFormElement("hasSoldHouse: \"Did you sell a house in 2010?\" boolean").getClass(), Question.class);
		assertEquals(parser.parseFormElement("hasBoughtHouse: \"Did you by a house in 2010?\" boolean").getClass(), Question.class);
		assertEquals(parser.parseFormElement("hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean").getClass(), Question.class);
		assertEquals(parser.parseFormElement("hasSoldHouse: \"Did you sell a house in 2010?\" boolean(blabla-haishgdiasd)").getClass(), FormText.class);
		
		assertEquals(parser.parseFormElements("hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n hasBoughtHouse: \"Did you by a house in 2010?\" boolean \n hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean").getClass(), ArrayList.class);
		List<FormElement> elements = parser.parseFormElements("hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n hasBoughtHouse: \"Did you by a house in 2010?\" boolean \n hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean");
		assertEquals(elements.size(), 3);
	}
	
	@Test
	public void testForm() throws ParseError {
		assertEquals(parser.parseForm("form Box1HouseOwning { \n hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n hasBoughtHouse: \"Did you by a house in 2010?\" boolean \n hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean \n}").getClass(), Form.class);
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
	
}