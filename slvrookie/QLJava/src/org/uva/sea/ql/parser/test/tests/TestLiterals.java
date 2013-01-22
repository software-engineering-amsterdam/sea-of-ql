package org.uva.sea.ql.parser.test.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.*;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;


public class TestLiterals{

		final private IParse parser = new ANTLRParser();


		@Test
		public void testIds() throws ParseError {
			assertEquals(Ident.class, parser.parseExpr("a").getClass());
			assertEquals(Ident.class, parser.parseExpr("abc").getClass());
			assertEquals(Ident.class, parser.parseExpr("ABC").getClass());
			assertEquals(Ident.class, parser.parseExpr("ABCDEF").getClass());
			assertEquals(Ident.class, parser.parseExpr("abc2323").getClass());
			assertEquals(Ident.class, parser.parseExpr("a2bc232").getClass());
			assertEquals(Ident.class, parser.parseExpr("a2bc232aa").getClass());
		}

		@Test
		public void testIntLiteral() throws ParseError {
			assertEquals(IntLiteral.class, parser.parseExpr("0").getClass());
			assertEquals(IntLiteral.class, parser.parseExpr("1223").getClass());
			assertEquals(IntLiteral.class, parser.parseExpr("234234234").getClass());
		}
		
		@Test
		public void testMoneyLiteral() throws ParseError {
			assertEquals(MoneyLiteral.class, parser.parseExpr("120.00").getClass());
			assertEquals(MoneyLiteral.class, parser.parseExpr("1231121.11").getClass());
			assertEquals(MoneyLiteral.class, parser.parseExpr("00.00").getClass());
			assertEquals(MoneyLiteral.class, parser.parseExpr("00.0021312").getClass());  
		}
		
		@Test
		public void testBooleanLiteral() throws ParseError {
			assertEquals(BoolLiteral.class, parser.parseExpr("true").getClass());
			assertEquals(BoolLiteral.class, parser.parseExpr("false").getClass());
		}
		
		@Test
		public void testStringLiteral() throws ParseError {
			assertEquals(StringLiteral.class, parser.parseExpr("\"trues  dat\"").getClass());
			assertEquals(StringLiteral.class, parser.parseExpr("\"true dat\"").getClass());
			assertEquals(StringLiteral.class, parser.parseExpr("\"true dat\" \" nice to SEE ya\"").getClass());
			assertEquals(StringLiteral.class, parser.parseExpr("\"True dat\" \n \t \" nice to SEE ya\"").getClass());
			assertEquals(StringLiteral.class, parser.parseExpr("\"tr<ue **dat\" \" nice) to SEE ya\"").getClass());
		}

}
