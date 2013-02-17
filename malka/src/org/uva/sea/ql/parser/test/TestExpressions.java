package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.bool.BooleanPrimitive;
import org.uva.sea.ql.ast.expression.bool.operation.logical.And;
import org.uva.sea.ql.ast.expression.bool.operation.logical.Not;
import org.uva.sea.ql.ast.expression.bool.operation.logical.Or;
import org.uva.sea.ql.ast.expression.bool.operation.relational.GT;
import org.uva.sea.ql.ast.expression.bool.operation.relational.LEq;
import org.uva.sea.ql.ast.expression.bool.operation.relational.LT;
import org.uva.sea.ql.ast.expression.integer.IntegerPrimitive;
import org.uva.sea.ql.ast.expression.integer.operation.Add;
import org.uva.sea.ql.ast.expression.integer.operation.Mul;
import org.uva.sea.ql.ast.expression.integer.operation.Neg;
import org.uva.sea.ql.ast.expression.integer.operation.Pos;
import org.uva.sea.ql.ast.expression.string.StringPrimitive;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.IFormElement;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.form.FormText;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestExpressions {

	private IParse parser;
	
	public TestExpressions() {
		this.parser = new ANTLRParser();
	}
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.parseExpr("3 + 2").getClass(), Add.class);
		assertEquals(parser.parseExpr("(3 + 2)").getClass(), Add.class);
		assertEquals(parser.parseExpr("a + b").getClass(), Add.class);
		assertEquals(parser.parseExpr("(a + b)").getClass(), Add.class);
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
		assertEquals(parser.parseExpr("5 * b").getClass(), Mul.class);
		assertEquals(parser.parseExpr("a * b").getClass(), Mul.class);
		assertEquals(parser.parseExpr("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parseExpr("(a * b * c)").getClass(), Mul.class);
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
		assertEquals(parser.parseExpr("a||b").getClass(), Or.class);
		assertEquals(parser.parseExpr("TRUE||FALSE").getClass(), Or.class);
		assertEquals(parser.parseExpr("TRUE").getClass(), BooleanPrimitive.class);
	}

	@Test
	public void testStrings() throws ParseError {
		assertEquals(parser.parseExpr("\"'a'\"").getClass(), StringPrimitive.class);
		assertEquals(parser.parseExpr("\"TRUE\"").getClass(), StringPrimitive.class);
		assertEquals(parser.parseExpr("\"1+4\"").getClass(), StringPrimitive.class);
		assertEquals(parser.parseExpr("\"Did you sell a house in 2010?\"").getClass(), StringPrimitive.class);
	}

	@Test
	public void testFormElements() throws ParseError {
		assertEquals(parser.parseFormElement("hasSoldHouse: \"Did you sell a house in 2010?\" boolean").getClass(), Question.class);
		assertEquals(parser.parseFormElement("hasBoughtHouse: \"Did you by a house in 2010?\" boolean").getClass(), Question.class);
		assertEquals(parser.parseFormElement("hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean").getClass(), Question.class);
		assertEquals(parser.parseFormElement("hasSoldHouse: \"Did you sell a house in 2010?\" boolean(blabla-haishgdiasd)").getClass(), FormText.class);
		
		assertEquals(parser.parseFormElements("hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n hasBoughtHouse: \"Did you by a house in 2010?\" boolean \n hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean").getClass(), ArrayList.class);
		List<IFormElement> elements = parser.parseFormElements("hasSoldHouse: \"Did you sell a house in 2010?\" boolean \n hasBoughtHouse: \"Did you by a house in 2010?\" boolean \n hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean");
		assertEquals(elements.size(), 3);
	}
	
	@Test
	public void testForm() throws ParseError {
		assertEquals(parser.parseForm("form Box1HouseOwning { \n hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean \n}").getClass(), Form.class);
		assertEquals(parser.parseForm("form Box1HouseOwning { \n hasSoldHouse: \"Did you sell a house in 2010?\" boolean\n hasBoughtHouse: \"Did you by a house in 2010?\" boolean\n hasMaintLoan: \"Did you enter a loan for maintenance/reconstruction?\" boolean \n if (hasSoldHouse) {\n sellingPrice: \"Price the house was sold for:\" integer\n privateDebt: \"Private debts for the sold house:\" integer\n valueResidue: \"Value residue:\" integer (sellingPrice - privateDebt)\n} }").getClass(), Form.class);
	}
	
	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parseExpr("a").getClass(), Identifier.class);
		assertEquals(parser.parseExpr("abc").getClass(), Identifier.class);
		assertEquals(parser.parseExpr("ABC").getClass(), Identifier.class);
		assertEquals(parser.parseExpr("ABCDEF").getClass(), Identifier.class);
		assertEquals(parser.parseExpr("abc2323").getClass(), Identifier.class);
		assertEquals(parser.parseExpr("a2bc232").getClass(), Identifier.class);
		assertEquals(parser.parseExpr("a2bc232aa").getClass(), Identifier.class);
	}
	
	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parseExpr("0").getClass(), IntegerPrimitive.class);
		assertEquals(parser.parseExpr("(0)").getClass(), IntegerPrimitive.class);
		assertEquals(parser.parseExpr("-1").getClass(), Neg.class);
		assertEquals(parser.parseExpr("+1").getClass(), Pos.class);
		assertEquals(parser.parseExpr("(-1)").getClass(), Neg.class);
		assertEquals(parser.parseExpr("(+1)").getClass(), Pos.class);
		assertEquals(parser.parseExpr("1223").getClass(), IntegerPrimitive.class);
		assertEquals(parser.parseExpr("234234234").getClass(), IntegerPrimitive.class);
	}
	
}