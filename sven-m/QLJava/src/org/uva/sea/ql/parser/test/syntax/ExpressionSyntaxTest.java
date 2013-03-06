package org.uva.sea.ql.parser.test.syntax;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.IntLiteral;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.StrLiteral;
import org.uva.sea.ql.ast.expression.Sub;


public class ExpressionSyntaxTest extends SyntaxTest {

	@Override
	protected Class<?> parseClass(String src) throws ParseError {
		return getParser().parseExpression(src).getClass();
	}
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(Add.class, parseClass("a + b"));
		assertEquals(Add.class, parseClass("a + b + c"));
		assertEquals(Add.class, parseClass("(a + b + c)"));
		assertEquals(Add.class, parseClass("a + (b + c)"));
		assertEquals(Add.class, parseClass("(a + b) + c"));
		assertEquals(Add.class, parseClass("(a + b)"));
		assertEquals(Add.class, parseClass("a + b * c"));
		assertEquals(Add.class, parseClass("a * b + c"));
	}
	
	@Test
	public void testSubs() throws ParseError {
		assertEquals(Sub.class, parseClass("a - b"));
		assertEquals(Sub.class, parseClass("a - b - c"));
		assertEquals(Sub.class, parseClass("(a - b - c)"));
		assertEquals(Sub.class, parseClass("a - (b - c)"));
		assertEquals(Sub.class, parseClass("(a - b) - c"));
		assertEquals(Sub.class, parseClass("(a - b)"));
		assertEquals(Sub.class, parseClass("a - b * c"));
		assertEquals(Sub.class, parseClass("a * b - c"));
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(Mul.class, parseClass("a * b"));
		assertEquals(Mul.class, parseClass("a * b * c"));
		assertEquals(Mul.class, parseClass("a * (b * c)"));
		assertEquals(Mul.class, parseClass("(a * b) * c"));
		assertEquals(Mul.class, parseClass("(a * b)"));
		assertEquals(Mul.class, parseClass("(a + b) * c"));
		assertEquals(Mul.class, parseClass("a * (b + c)"));
	}
	
	@Test
	public void testDivs() throws ParseError {
		assertEquals(Div.class, parseClass("a / b"));
		assertEquals(Div.class, parseClass("a / b / c"));
		assertEquals(Div.class, parseClass("a / (b / c)"));
		assertEquals(Div.class, parseClass("(a / b) / c"));
		assertEquals(Div.class, parseClass("(a / b)"));
		assertEquals(Div.class, parseClass("(a + b) / c"));
		assertEquals(Div.class, parseClass("a / (b + c)"));
	}

	@Test
	public void testRels() throws ParseError {
		assertEquals(LT.class, parseClass("a < b"));
		assertEquals(LT.class, parseClass("a < b + c"));
		assertEquals(LT.class, parseClass("a < (b * c)"));
		assertEquals(LT.class, parseClass("(a * b) < c"));
		
		assertEquals(LEq.class, parseClass("(a <= b)"));
		assertEquals(LEq.class, parseClass("(a + b <= b)"));
		assertEquals(LEq.class, parseClass("(a <= b * c)"));
		assertEquals(LEq.class, parseClass("(a - b * c <= b)"));
		assertEquals(LEq.class, parseClass("(a <= b)"));
		
		assertEquals(Eq.class, parseClass("a + b == c"));
		assertEquals(Eq.class, parseClass("a == b + c"));
		assertEquals(Eq.class, parseClass("a + b == c"));
		assertEquals(Eq.class, parseClass("a == b + c"));
		
		assertEquals(GEq.class, parseClass("(a >= b)"));
		assertEquals(GEq.class, parseClass("(a + b >= b)"));
		assertEquals(GEq.class, parseClass("(a >= b * c)"));
		assertEquals(GEq.class, parseClass("(a - b * c >= b)"));
		assertEquals(GEq.class, parseClass("(a >= b)"));
		
		assertEquals(GT.class, parseClass("a + b > c"));
		assertEquals(GT.class, parseClass("a > b + c"));
		assertEquals(GT.class, parseClass("a + b > c"));
		assertEquals(GT.class, parseClass("a > b + c"));
	}

	@Test
	public void testBools() throws ParseError {
		assertEquals(Not.class, parseClass("!b"));
		assertEquals(Not.class, parseClass("!(a == b)"));
		assertEquals(Not.class, parseClass("!(b && c)"));
		assertEquals(Not.class, parseClass("!(d == (e && f) || g)"));
		
		assertEquals(And.class, parseClass("a && b"));
		assertEquals(And.class, parseClass("a > b && b > c"));
		assertEquals(And.class, parseClass("(a > b) && (b > c)"));
		
		assertEquals(Or.class, parseClass("a || b"));
		assertEquals(Or.class, parseClass("a > b || b > c"));
		assertEquals(Or.class, parseClass("a && b || c"));
	}

	@Test
	public void testIds() throws ParseError {
		assertEquals(Ident.class, parseClass("a"));
		assertEquals(Ident.class, parseClass("abc"));
		assertEquals(Ident.class, parseClass("ABC"));
		assertEquals(Ident.class, parseClass("ABCDEF"));
		assertEquals(Ident.class, parseClass("abc2323"));
		assertEquals(Ident.class, parseClass("a2bc232"));
		assertEquals(Ident.class, parseClass("a2bc232aa"));
	}

	@Test
	public void testInts() throws ParseError {
		assertEquals(IntLiteral.class, parseClass("0"));
		assertEquals(IntLiteral.class, parseClass("00000000000000"));
		assertEquals(IntLiteral.class, parseClass("1223"));
		assertEquals(IntLiteral.class, parseClass("234234234"));
		assertEquals(IntLiteral.class, parseClass("000000003"));
		
		assertEquals(Pos.class, parseClass("+0"));
		assertEquals(Pos.class, parseClass("+00000000000000"));
		assertEquals(Pos.class, parseClass("+1223"));
		assertEquals(Pos.class, parseClass("+234234234"));
		assertEquals(Pos.class, parseClass("+000000003"));
		
		assertEquals(Neg.class, parseClass("-0"));
		assertEquals(Neg.class, parseClass("-00000000000000"));
		assertEquals(Neg.class, parseClass("-1223"));
		assertEquals(Neg.class, parseClass("-234234234"));
		assertEquals(Neg.class, parseClass("-000000003"));
	}
	
	@Test
	public void testStrings() throws ParseError {
		assertEquals(StrLiteral.class, parseClass("\"\""));
		assertEquals(StrLiteral.class, parseClass("\"a\""));
		assertEquals(StrLiteral.class, parseClass("\"fdT$)G*(FHE\""));
	}

}
