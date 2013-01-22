package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.ast.expr.Mul;
import org.uva.sea.ql.ast.values.Int;
import org.uva.sea.ql.ast.expr.Ident;
import org.uva.sea.ql.parser.antlr.ANTLRParser;




@RunWith(Parameterized.class)
public class TestExpressions {

	private IParse parser;

	
	
	@Parameters
	public static List<Object[]> theParsers() {
		
		List<Object[]> listANTLR=  new ArrayList<Object[]>();
		listANTLR.add(new Object[] {new ANTLRParser()});
		return listANTLR;
			 
	} 

	
	public TestExpressions(IParse parser) {
		this.parser = parser;
		
	}

	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(Add.class,parser.parseExpr("3.23 + 7.34").getClass());
		assertEquals(Add.class,parser.parseExpr("a + b + c ").getClass());
		assertEquals(Add.class,parser.parseExpr("(a + b + c)").getClass());
		assertEquals(Add.class,parser.parseExpr("a + (b + c)").getClass());
		assertEquals(Add.class,parser.parseExpr("(a + b) + c").getClass());
		assertEquals(Add.class,parser.parseExpr("(a + b)").getClass());
		assertEquals(Add.class,parser.parseExpr("a + b * c").getClass());
		assertEquals(Add.class,parser.parseExpr("a * b + c").getClass());
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(Mul.class,parser.parseExpr("a * b").getClass());
		assertEquals(Mul.class,parser.parseExpr("a * b * c").getClass());
		assertEquals(Mul.class,parser.parseExpr("a * 33.3 * b) * c").getClass());
		assertEquals(Mul.class,parser.parseExpr("(a * b)").getClass());
		assertEquals(Mul.class,parser.parseExpr("(a + b) * c").getClass());
		assertEquals(Mul.class,parser.parseExpr("a * (b + c)").getClass());
		assertEquals(Mul.class,parser.parseExpr("(-a) * (b + c)").getClass());
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(LT.class,parser.parseExpr("a < b").getClass());
		assertEquals(LT.class,parser.parseExpr("a < b + c").getClass());
		assertEquals(LT.class,parser.parseExpr("a < (b * c)").getClass());
		assertEquals(LT.class,parser.parseExpr("(a * b) < c").getClass());
		assertEquals(LEq.class,parser.parseExpr("(a <= b)").getClass());
		assertEquals(GT.class,parser.parseExpr("a + b > c").getClass());
		assertEquals(GT.class,parser.parseExpr("a > b + c").getClass());
	
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(Ident.class,parser.parseExpr("a").getClass());
		assertEquals(Ident.class,parser.parseExpr("abc").getClass());
		assertEquals(Ident.class,parser.parseExpr("ABC").getClass());
		assertEquals(Ident.class,parser.parseExpr("ABCDEF").getClass());
		assertEquals(Ident.class,parser.parseExpr("abc2323").getClass());
		assertEquals(Ident.class,parser.parseExpr("a2bc232").getClass());
		assertEquals(Ident.class,parser.parseExpr("a2bc232aa").getClass());
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(Int.class,parser.parseExpr("0").getClass());
		assertEquals(Int.class,parser.parseExpr("1223").getClass());
		assertEquals(Int.class,parser.parseExpr("234234234").getClass());
	}
	
}
