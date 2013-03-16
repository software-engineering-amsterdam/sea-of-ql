package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntLiteral;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JaccQLParser;

public class TestExpressions {

	private IParse parser;
	
	@Before
	public void setup(){
		parser = new JaccQLParser();
	}
	
	private Class parse(String qlText) throws ParseError{
		return parser.parseExpression(qlText).getClass();
	}
	
	@Test
	public void testPos() throws ParseError{
		assertEquals(Pos.class, parse("+b"));
		assertEquals(Pos.class, parse("+ (b * c)"));
		assertEquals(Pos.class, parse("+ (b - a)"));
	}
	
	@Test
	public void testNeg() throws ParseError{
		assertEquals(Neg.class, parse("-b"));
		assertEquals(Neg.class, parse("- (b * c)"));
		assertEquals(Neg.class, parse("- (b - a)"));
	}
	
	@Test
	public void testNot() throws ParseError{
		assertEquals(Not.class, parse("!b"));
		assertEquals(Not.class, parse("!(a+b)"));
		assertEquals(Not.class, parse("!(a-b + (x * d))"));
	}
	
	@Test
	public void testMuls() throws ParseError {
		assertEquals(Mul.class, parse("a * b"));
		assertEquals(Mul.class, parse("a * b * c"));
		assertEquals(Mul.class, parse("a * (b * c)"));
		assertEquals(Mul.class, parse("(a * b) * c"));
		assertEquals(Mul.class, parse("(a * b)"));
		assertEquals(Mul.class, parse("(a + b) * c"));
		assertEquals(Mul.class, parse("a * (b + c)"));
	}
	
	@Test
	public void testDivision() throws ParseError {
		assertEquals(Div.class, parse("a / b"));
		assertEquals(Div.class, parse("a / b /c"));
		assertEquals(Div.class, parse("(a + b) / c"));
	}
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(Add.class, parse("a + b"));
		assertEquals(Add.class, parse("a + b + c"));
		assertEquals(Add.class, parse("(a + b + c)"));
		assertEquals(Add.class, parse("a + (b + c)"));
		assertEquals(Add.class, parse("(a + b) + c"));
		assertEquals(Add.class, parse("(a + b)"));
		assertEquals(Add.class, parse("a + b * c"));
		assertEquals(Add.class, parse("a * b + c"));
	}
	
	@Test
	public void testSubs() throws ParseError {
		assertEquals(Sub.class, parse("a - b"));
		assertEquals(Sub.class, parse("a - b - c"));
		assertEquals(Sub.class, parse("(a - b - c)"));
		assertEquals(Sub.class, parse("a - (b - c)"));
		assertEquals(Sub.class, parse("(a - b) - c"));
		assertEquals(Sub.class, parse("(a - b)"));
		assertEquals(Sub.class, parse("a - b * c"));
		assertEquals(Sub.class, parse("a * b - c"));
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(LT.class, parse("a < b"));
		assertEquals(LT.class, parse("a < b + c"));
		assertEquals(LT.class, parse("a < (b * c)"));
		assertEquals(LT.class, parse("(a * b) < c"));
		assertEquals(LEq.class, parse("(a <= b)"));
		assertEquals(GT.class, parse("a + b > c"));
		assertEquals(GT.class, parse("a > b + c"));
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(Identifier.class, parse("a"));
		assertEquals(Identifier.class, parse("abc"));
		assertEquals(Identifier.class, parse("ABC"));
		assertEquals(Identifier.class, parse("ABCDEF"));
		assertEquals(Identifier.class, parse("abc2323"));
		assertEquals(Identifier.class, parse("a2bc232"));
		assertEquals(Identifier.class, parse("a2bc232aa"));
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(IntLiteral.class, parse("0"));
		assertEquals(IntLiteral.class, parse("1223"));
		assertEquals(IntLiteral.class, parse("234234234"));
	}
	
	@Test
	public void testBools() throws ParseError {
		assertEquals(BooleanLiteral.class, parse("true"));
		assertEquals(BooleanLiteral.class, parse("false"));
	}
}
