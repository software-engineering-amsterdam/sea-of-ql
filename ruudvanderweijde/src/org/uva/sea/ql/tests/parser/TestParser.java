package org.uva.sea.ql.tests.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.binary.Add;
import org.uva.sea.ql.ast.expr.binary.Div;
import org.uva.sea.ql.ast.expr.binary.GT;
import org.uva.sea.ql.ast.expr.binary.LEq;
import org.uva.sea.ql.ast.expr.binary.LT;
import org.uva.sea.ql.ast.expr.binary.Mul;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.expr.primary.Int;
import org.uva.sea.ql.ast.stmt.IfThen;
import org.uva.sea.ql.ast.stmt.IfThenElse;
import org.uva.sea.ql.ast.stmt.Statement;
import org.uva.sea.ql.ast.stmt.question.ComputedQuestion;
import org.uva.sea.ql.ast.stmt.question.NormalQuestion;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.error.ParseError;

public class TestParser {
	private final IParse parser = new ANTLRParser();

	@Test
	public void testStatement() throws ParseError {
		assertEquals(getClassOfStatement("if (a) { }"), IfThen.class);
		assertEquals(getClassOfStatement("if (true) { question: \"\" boolean }"), IfThen.class);
		
		assertEquals(getClassOfStatement("if (a) { } else { b: \"lege string\" boolean }"), IfThenElse.class);
		assertEquals(getClassOfStatement("if (true) { b: \"lege string\" boolean } else { b: \"lege string\" boolean }"), IfThenElse.class);
	
		assertEquals(getClassOfStatement("s: \"string\" string"), NormalQuestion.class);
		assertEquals(getClassOfStatement("b: \"boolean test\" boolean"), NormalQuestion.class);
		
		assertEquals(getClassOfStatement("i1: \"integer test12\" integer (10+100)"), ComputedQuestion.class);
		assertEquals(getClassOfStatement("i2: \"integer test\" integer (10-1)"), ComputedQuestion.class);
	}

	@Test
	public void testForm() throws ParseError {
		assertEquals(getClassOfForm("form Box1HouseOwning { }"), Form.class);
		assertEquals(getClassOfForm("form Box1HouseOwning { if (a) { } }"), Form.class);
		assertEquals(getClassOfForm("form Box1HouseOwning { s: \"string\" string }"), Form.class);
		assertEquals(getClassOfForm("form Box1HouseOwning { b: \"lege string\" boolean }"), Form.class);
		assertEquals(getClassOfForm("form Box1HouseOwning { if (a) { } else { b: \"lege string\" boolean } }"), Form.class);
		assertEquals(getClassOfForm("form Box1HouseOwning { hasSoldHouse: \"Did you sell a house in 2010?\" boolean }"), Form.class);
	}
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(getClassOfExpression("a + b"), Add.class);
		assertEquals(getClassOfExpression("(a + b)"), Add.class);
		assertEquals(getClassOfExpression("a + b + c"), Add.class);
		assertEquals(getClassOfExpression("a + b * c"), Add.class);
		assertEquals(getClassOfExpression("a * b + c"), Add.class);
		assertEquals(getClassOfExpression("(a + b + c)"), Add.class);
		assertEquals(getClassOfExpression("a + (b + c)"), Add.class);
		assertEquals(getClassOfExpression("(a + b) + c"), Add.class);
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(getClassOfExpression("a * b"), Mul.class);
		assertEquals(getClassOfExpression("(a * b)"), Mul.class);
		assertEquals(getClassOfExpression("a * b * c"), Mul.class);
		assertEquals(getClassOfExpression("a * (b * c)"), Mul.class);
		assertEquals(getClassOfExpression("(a * b) * c"), Mul.class);
		assertEquals(getClassOfExpression("(a + b) * c"), Mul.class);
		assertEquals(getClassOfExpression("a * (b + c)"), Mul.class);
	}
	
	@Test
	public void testDivs() throws ParseError {
		assertEquals(getClassOfExpression("a / b"), Div.class);
		assertEquals(getClassOfExpression("(a / b)"), Div.class);
		assertEquals(getClassOfExpression("a / b / c"), Div.class);
		assertEquals(getClassOfExpression("a / (b / c)"), Div.class);
		assertEquals(getClassOfExpression("(a / b) / c"), Div.class);
		assertEquals(getClassOfExpression("(a + b) / c"), Div.class);
		assertEquals(getClassOfExpression("a / (b + c)"), Div.class);
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(getClassOfExpression("a < b"), LT.class);
		assertEquals(getClassOfExpression("(a <= b)"), LEq.class);
		assertEquals(getClassOfExpression("a < b + c"), LT.class);
		assertEquals(getClassOfExpression("a + b > c"), GT.class);
		assertEquals(getClassOfExpression("a > b + c"), GT.class);
		assertEquals(getClassOfExpression("a < (b * c)"), LT.class);
		assertEquals(getClassOfExpression("(a * b) < c"), LT.class);
	}

	@Test
	public void testIds() throws ParseError {
		assertEquals(getClassOfExpression("a"), Ident.class);
		assertEquals(getClassOfExpression("abc"), Ident.class);
		assertEquals(getClassOfExpression("ABC"), Ident.class);
		assertEquals(getClassOfExpression("ABCDEF"), Ident.class);
		assertEquals(getClassOfExpression("abc2323"), Ident.class);
		assertEquals(getClassOfExpression("a2bc232"), Ident.class);
		assertEquals(getClassOfExpression("a2bc232aa"), Ident.class);
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(getClassOfExpression("0"), Int.class);
		assertEquals(getClassOfExpression("23"), Int.class);
		assertEquals(getClassOfExpression("1223"), Int.class);
		assertEquals(getClassOfExpression("544342"), Int.class);
		assertEquals(getClassOfExpression("234234234"), Int.class);
	}
	
	private Class<? extends Form> getClassOfForm(String strExpression) throws ParseError {
		return parser.parseForm(strExpression).getClass();
	}
	private Class<? extends Statement> getClassOfStatement(String strExpression) throws ParseError {
		return parser.parseStatement(strExpression).getClass();
	}
	private Class<? extends Expr> getClassOfExpression(String strExpression) throws ParseError {
		return parser.parseExpression(strExpression).getClass();
	}
}
