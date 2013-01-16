package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.GT;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Int;
import org.uva.sea.ql.ast.LEq;
import org.uva.sea.ql.ast.LT;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

@RunWith(Parameterized.class)
public class TestExpressions {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[] {new ANTLRParser()});
		return list;
	}

	
	public TestExpressions(IParse parser) {
		this.parser = parser;
	}

	
	@Test
	public void testAdds() throws ParseError {
		System.out.println(parser.parse("a + b").getClass());
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
	public void testCalculation() throws ParseError {
		assertEquals(
				((org.uva.sea.ql.ast.values.Int)parser.parse("1 + 2").eval()).getValue(), 
				((org.uva.sea.ql.ast.values.Int)parser.parse("3").eval()).getValue());
		assertEquals(
				((org.uva.sea.ql.ast.values.Int)parser.parse("1 + 2 * 3").eval()).getValue(), 
				((org.uva.sea.ql.ast.values.Int)parser.parse("7").eval()).getValue());
		assertEquals(
				((org.uva.sea.ql.ast.values.Int)parser.parse("(1 + 2) * 3").eval()).getValue(), 
				((org.uva.sea.ql.ast.values.Int)parser.parse("9").eval()).getValue());
		assertEquals(
				((org.uva.sea.ql.ast.values.Int)parser.parse("(1 + 2) * 3 - (2 + 3)").eval()).getValue(), 
				((org.uva.sea.ql.ast.values.Int)parser.parse("4").eval()).getValue());
	}
	
	@Test 
	public void testQuestionForm() throws ParseError {
		assertEquals(parser.parseForm("form testForm1 {\n" +
				"demoQuestion: \"Is this really a question?\"" +
				"}").getClass(),Form.class);
		assertEquals(parser.parseForm("form testForm2 {\n" +
				"hasSoldHouse: \"Have you sold a house in 2012?\"\n" +
				"hasBoughtHouse: \"Have you bought a house in 2012?\"\n" +
				"}").getQuestions().size(),2);
		assertEquals(parser.parseForm("form testForm3 {\n" +
				"demoQuestion: \"Is this really a question?\"" +
				"if (demoQuestion) {" +
				"	demoQuestion2: \"So this must also be a question then?\"" +
				"}" +
				"}").getClass(),Form.class);
	}
	
}
