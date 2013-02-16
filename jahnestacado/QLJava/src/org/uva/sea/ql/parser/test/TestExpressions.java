package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.ast.expr.binary.algebraic.Add;
import org.uva.sea.ql.ast.expr.binary.algebraic.Div;
import org.uva.sea.ql.ast.expr.binary.algebraic.Mul;
import org.uva.sea.ql.ast.expr.binary.algebraic.Sub;
import org.uva.sea.ql.ast.expr.binary.bool.And;
import org.uva.sea.ql.ast.expr.binary.bool.Eq;
import org.uva.sea.ql.ast.expr.binary.bool.GEq;
import org.uva.sea.ql.ast.expr.binary.bool.GT;
import org.uva.sea.ql.ast.expr.binary.bool.LEq;
import org.uva.sea.ql.ast.expr.binary.bool.LT;
import org.uva.sea.ql.ast.expr.binary.bool.NEq;
import org.uva.sea.ql.ast.expr.binary.bool.Or;
import org.uva.sea.ql.ast.expr.unary.Neg;
import org.uva.sea.ql.ast.expr.unary.Not;
import org.uva.sea.ql.ast.expr.unary.Pos;
import org.uva.sea.ql.ast.expr.values.BoolLit;
import org.uva.sea.ql.ast.expr.values.DecimalLit;
import org.uva.sea.ql.ast.expr.values.IntegerLit;
import org.uva.sea.ql.ast.expr.values.StringLit;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestExpressions {

	private ANTLRParser parser;

	public TestExpressions() {

		parser = new ANTLRParser();

	}

	@Test
	public void testBinAlgebraic() throws ParseError {
		assertEquals(Mul.class, parser.parseExpr("(a * b)").getClass());
		assertEquals(Mul.class, parser.parseExpr("(a + b) * c").getClass());
		assertEquals(Mul.class, parser.parseExpr("a * (b + c)").getClass());
		assertEquals(Mul.class, parser.parseExpr("(-a) * (b + c)").getClass());
		
		assertEquals(Add.class, parser.parseExpr("(a + b) + c").getClass());
		assertEquals(Add.class, parser.parseExpr("(a + b)").getClass());
		assertEquals(Add.class, parser.parseExpr("a +( b * c)").getClass());
		assertEquals(Add.class, parser.parseExpr("a * b + c").getClass());
		
		assertEquals(Sub.class, parser.parseExpr("(a + b) - c").getClass());
		assertEquals(Sub.class, parser.parseExpr("(a - b)").getClass());
		assertEquals(Sub.class, parser.parseExpr("a -( b / c)").getClass());
		assertEquals(Sub.class, parser.parseExpr("(a * b) - c").getClass());
		
		assertEquals(Div.class, parser.parseExpr("(a + b) / c").getClass());
		assertEquals(Div.class, parser.parseExpr("(a / b)").getClass());
		assertEquals(Div.class, parser.parseExpr("a /( b / c)").getClass());
		assertEquals(Div.class, parser.parseExpr("(a * b) / c").getClass());
	}


	@Test
	public void testBinBool() throws ParseError {
		assertEquals(Or.class, parser.parseExpr("a || (b && c)").getClass());
		assertEquals(Or.class, parser.parseExpr("(a * b) || c").getClass());
		
		assertEquals(And.class, parser.parseExpr("a && (b && c)").getClass());
		assertEquals(And.class, parser.parseExpr("(a * b) && c").getClass());
		
		assertEquals(LT.class, parser.parseExpr("a < (b * c)").getClass());
		assertEquals(LT.class, parser.parseExpr("(a * b) < c").getClass());
		
		assertEquals(LEq.class, parser.parseExpr("(a * b) <= c").getClass());
		assertEquals(LEq.class, parser.parseExpr("(a <= b)").getClass());
		
		assertEquals(GT.class, parser.parseExpr("a + b > c").getClass());
		assertEquals(GT.class, parser.parseExpr("a > b + c").getClass());
		
		assertEquals(GEq.class, parser.parseExpr("a + b >= c").getClass());
		assertEquals(GEq.class, parser.parseExpr("(a * b) >= b + c").getClass());
		
		assertEquals(Eq.class, parser.parseExpr("(a +b)== c").getClass());
		assertEquals(Eq.class, parser.parseExpr("a ==(b * c)").getClass());
		
		assertEquals(NEq.class, parser.parseExpr("(a +b)!= c").getClass());
		assertEquals(NEq.class, parser.parseExpr("a !=(b * c)").getClass());
	}
	
	@Test
	public void testUnary() throws ParseError {
		assertEquals(Neg.class, parser.parseExpr("-(b * b)").getClass());
		assertEquals(Neg.class, parser.parseExpr("-((a * b) - b)").getClass());
		
		assertEquals(Pos.class, parser.parseExpr("+(b * b)").getClass());
		assertEquals(Pos.class, parser.parseExpr("+((a * b) - b)").getClass());
		
		assertEquals(Not.class, parser.parseExpr("!(b * b)").getClass());
		assertEquals(Not.class, parser.parseExpr("!((a * b) - b)").getClass());
	
	}
	
	


	@Test
	public void testIds() throws ParseError {
		assertEquals(Ident.class, parser.parseExpr("a").getClass());
		assertEquals(Ident.class, parser.parseExpr("abc").getClass());
		assertEquals(Ident.class, parser.parseExpr("ABC").getClass());
		assertEquals(Ident.class, parser.parseExpr("ABCDEF").getClass());
		assertEquals(Ident.class, parser.parseExpr("abc2323").getClass());
		assertEquals(Ident.class, parser.parseExpr("a2bA232").getClass());
		assertEquals(Ident.class, parser.parseExpr("a2bc232aa").getClass());
	}

	@Test
	public void testValues() throws ParseError {
		assertEquals(IntegerLit.class, parser.parseExpr("0").getClass());
		assertEquals(IntegerLit.class, parser.parseExpr("1223").getClass());
		assertEquals(IntegerLit.class, parser.parseExpr("234234234").getClass());
		
		assertEquals(DecimalLit.class, parser.parseExpr("0.0").getClass());
		assertEquals(DecimalLit.class, parser.parseExpr("12.23").getClass());
		assertEquals(DecimalLit.class, parser.parseExpr("2342.34234").getClass());
		
		assertEquals(StringLit.class, parser.parseExpr("\"foo\"").getClass());
		assertEquals(StringLit.class, parser.parseExpr("\"foo87\"").getClass());
		assertEquals(StringLit.class, parser.parseExpr("\"foo john smith\"").getClass());
		
		assertEquals(BoolLit.class, parser.parseExpr("true").getClass());
		assertEquals(BoolLit.class, parser.parseExpr("false").getClass());
	
	}

}
