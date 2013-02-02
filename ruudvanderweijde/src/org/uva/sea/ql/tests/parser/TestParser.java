package org.uva.sea.ql.tests.parser;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.expr.primary.Int;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.question.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.question.NormalQuestion;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.tests.IParse;

@RunWith(Parameterized.class)
public class TestParser {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		Object[][] data = new Object[][] { new Object[] {new ANTLRParser()} };
		return Arrays.asList(data);
	}

	
	public TestParser(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testStatement() throws ParseError {
		String strQL1 = "if (true) { question: \"\" boolean }";
		String strQL2 = "if (a) { }";
		String strQL3 = "if (true) { b: \"lege string\" boolean } else { b: \"lege string\" boolean }";
		String strQL4 = "if (a) { } else { b: \"lege string\" boolean }";
		String strQL5 = "s: \"string\" string";
		String strQL6 = "b: \"boolean test\" boolean";
		String strQL7 = "i1: \"integer test12\" integer (10+100)";
		String strQL8 = "i2: \"integer test\" integer (10-1)";
		
		
		assertEquals(parser.parseStatement(strQL1).getClass(), IfThenElse.class);
		assertEquals(parser.parseStatement(strQL2).getClass(), IfThenElse.class);
		assertEquals(parser.parseStatement(strQL3).getClass(), IfThenElse.class);
		assertEquals(parser.parseStatement(strQL4).getClass(), IfThenElse.class);
		assertEquals(parser.parseStatement(strQL5).getClass(), NormalQuestion.class);
		assertEquals(parser.parseStatement(strQL6).getClass(), NormalQuestion.class);
		assertEquals(parser.parseStatement(strQL7).getClass(), ComputedQuestion.class);
		assertEquals(parser.parseStatement(strQL8).getClass(), ComputedQuestion.class);
	}

	@Test
	public void testForm() throws ParseError {
		String strQL1 = "form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean }";
		String strQL2 = "form Box1HouseOwning { }";
		String strQL3 = "form Box1HouseOwning { if (a) { } }";
		String strQL4 = "form Box1HouseOwning { if (a) { } else { b: \"lege string\" boolean } }";
		String strQL5 = "form Box1HouseOwning { b: \"lege string\" boolean }";
		String strQL6 = "form Box1HouseOwning { s: \"string\" string }";
		
		
		assertEquals(parser.parseForm(strQL1).getClass(), Form.class);
		assertEquals(parser.parseForm(strQL2).getClass(), Form.class);
		assertEquals(parser.parseForm(strQL3).getClass(), Form.class);
		assertEquals(parser.parseForm(strQL4).getClass(), Form.class);
		assertEquals(parser.parseForm(strQL5).getClass(), Form.class);
		assertEquals(parser.parseForm(strQL6).getClass(), Form.class);
	}
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(parser.parseExpression("a + b").getClass(), Add.class);
		assertEquals(parser.parseExpression("a + b + c").getClass(), Add.class);
		assertEquals(parser.parseExpression("(a + b + c)").getClass(), Add.class);
		assertEquals(parser.parseExpression("a + (b + c)").getClass(), Add.class);
		assertEquals(parser.parseExpression("(a + b) + c").getClass(), Add.class);
		assertEquals(parser.parseExpression("(a + b)").getClass(), Add.class);
		assertEquals(parser.parseExpression("a + b * c").getClass(), Add.class);
		assertEquals(parser.parseExpression("a * b + c").getClass(), Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(parser.parseExpression("a * b").getClass(), Mul.class);
		assertEquals(parser.parseExpression("a * b * c").getClass(), Mul.class);
		assertEquals(parser.parseExpression("a * (b * c)").getClass(), Mul.class);
		assertEquals(parser.parseExpression("(a * b) * c").getClass(), Mul.class);
		assertEquals(parser.parseExpression("(a * b)").getClass(), Mul.class);
		assertEquals(parser.parseExpression("(a + b) * c").getClass(), Mul.class);
		assertEquals(parser.parseExpression("a * (b + c)").getClass(), Mul.class);
	}
	
	@Test
	public void testDivs() throws ParseError {
		assertEquals(parser.parseExpression("a / b").getClass(), Div.class);
		assertEquals(parser.parseExpression("a / b / c").getClass(), Div.class);
		assertEquals(parser.parseExpression("a / (b / c)").getClass(), Div.class);
		assertEquals(parser.parseExpression("(a / b) / c").getClass(), Div.class);
		assertEquals(parser.parseExpression("(a / b)").getClass(), Div.class);
		assertEquals(parser.parseExpression("(a + b) / c").getClass(), Div.class);
		assertEquals(parser.parseExpression("a / (b + c)").getClass(), Div.class);
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(parser.parseExpression("a < b").getClass(), LT.class);
		assertEquals(parser.parseExpression("a < b + c").getClass(), LT.class);
		assertEquals(parser.parseExpression("a < (b * c)").getClass(), LT.class);
		assertEquals(parser.parseExpression("(a * b) < c").getClass(), LT.class);
		assertEquals(parser.parseExpression("(a <= b)").getClass(), LEq.class);
		assertEquals(parser.parseExpression("a + b > c").getClass(), GT.class);
		assertEquals(parser.parseExpression("a > b + c").getClass(), GT.class);
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(parser.parseExpression("a").getClass(), Ident.class);
		assertEquals(parser.parseExpression("abc").getClass(), Ident.class);
		assertEquals(parser.parseExpression("ABC").getClass(), Ident.class);
		assertEquals(parser.parseExpression("ABCDEF").getClass(), Ident.class);
		assertEquals(parser.parseExpression("abc2323").getClass(), Ident.class);
		assertEquals(parser.parseExpression("a2bc232").getClass(), Ident.class);
		assertEquals(parser.parseExpression("a2bc232aa").getClass(), Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(parser.parseExpression("0").getClass(), Int.class);
		assertEquals(parser.parseExpression("1223").getClass(), Int.class);
		assertEquals(parser.parseExpression("234234234").getClass(), Int.class);
	}
	
}
