package org.uva.sea.ql.tests.visitor;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.value.BoolLiteral;
import org.uva.sea.ql.ast.expr.value.IntLiteral;
import org.uva.sea.ql.ast.expr.value.Value;
import org.uva.sea.ql.parser.antlr.ANTLRParser;
import org.uva.sea.ql.parser.antlr.IParse;
import org.uva.sea.ql.parser.antlr.ParseError;
import org.uva.sea.ql.visitors.ExprEvaluator;

public class TestExprEvaluator {

		final Map<String, Value> env = new HashMap<String, Value>();
		final private IParse parser = new ANTLRParser();
		ExprEvaluator eval = new ExprEvaluator(env);
		

	
		@Test
		public void testAdds() throws ParseError {
			assertEquals(15 , ((IntLiteral) parser.parseExpr("10 + 5").accept(eval)).getValue());
			assertEquals(15 , ((IntLiteral) parser.parseExpr("10 + 2 + 3").accept(eval)).getValue());
			assertEquals(15 , ((IntLiteral) parser.parseExpr("(5 + 5 + 5)").accept(eval)).getValue());
			assertEquals(15 , ((IntLiteral) parser.parseExpr("5 + (5 + 5)").accept(eval)).getValue());
			assertEquals(15 , ((IntLiteral) parser.parseExpr("(5 + 5) + 5").accept(eval)).getValue());
			assertEquals(10 , ((IntLiteral) parser.parseExpr("(5 + 5)").accept(eval)).getValue());
			assertEquals(15 , ((IntLiteral) parser.parseExpr("5 + 5 * 2").accept(eval)).getValue());
			assertEquals(15 , ((IntLiteral) parser.parseExpr("2 * 5 + 5").accept(eval)).getValue());
		}

		@Test
		public void testSubs() throws ParseError {
			assertEquals(15 , ((IntLiteral) parser.parseExpr("20 - 5").accept(eval)).getValue());
			assertEquals(15 , ((IntLiteral) parser.parseExpr("20 - 2 - 3").accept(eval)).getValue());
			assertEquals(15 , ((IntLiteral) parser.parseExpr("(25 - 5 - 5)").accept(eval)).getValue());
			assertEquals(15 , ((IntLiteral) parser.parseExpr("25 - (5 + 5)").accept(eval)).getValue());
			assertEquals(15 , ((IntLiteral) parser.parseExpr("(10 + 10) - 5").accept(eval)).getValue());
			assertEquals(10 , ((IntLiteral) parser.parseExpr("(20 - 10)").accept(eval)).getValue());
			assertEquals(15 , ((IntLiteral) parser.parseExpr("30 - 5 * 3").accept(eval)).getValue());
			assertEquals(15 , ((IntLiteral) parser.parseExpr("2 * 10 - 5").accept(eval)).getValue());
		}
		
		@Test
		public void testUnaries() throws ParseError {
			assertEquals(15 , ((IntLiteral) parser.parseExpr(" + 15").accept(eval)).getValue());
			assertEquals(-15 , ((IntLiteral) parser.parseExpr(" - 15").accept(eval)).getValue());
			assertEquals(15 , ((IntLiteral) parser.parseExpr(" +(25 - 5 - 5)").accept(eval)).getValue());
			assertEquals(-15 , ((IntLiteral) parser.parseExpr("-(25 - (5 + 5))").accept(eval)).getValue());
			assertEquals(-25 , ((IntLiteral) parser.parseExpr("-(10 + 10) - 5").accept(eval)).getValue());
			assertEquals(-10 , ((IntLiteral) parser.parseExpr("-(20 - 10)").accept(eval)).getValue());
			assertEquals(-15 , ((IntLiteral) parser.parseExpr("-1 * (30 - 5 * 3)").accept(eval)).getValue());
		}
		
		@Test
		public void testMul() throws ParseError {
			assertEquals(100 , ((IntLiteral) parser.parseExpr("20 * 5").accept(eval)).getValue());
			assertEquals(120 , ((IntLiteral) parser.parseExpr("20 * 2 * 3").accept(eval)).getValue());
			assertEquals(125 , ((IntLiteral) parser.parseExpr("(5 * 5 * 5)").accept(eval)).getValue());
			assertEquals(250 , ((IntLiteral) parser.parseExpr("25 * (5 + 5)").accept(eval)).getValue());
			assertEquals(100 , ((IntLiteral) parser.parseExpr("(10 + 10) * 5").accept(eval)).getValue());
			assertEquals(200 , ((IntLiteral) parser.parseExpr("(20 * 10)").accept(eval)).getValue());
			assertEquals(80 , ((IntLiteral) parser.parseExpr("10 * (5 + 3)").accept(eval)).getValue());
		}
		
		@Test
		public void testDivs() throws ParseError {
			assertEquals(4 , ((IntLiteral) parser.parseExpr("20 / 5").accept(eval)).getValue());
			assertEquals(11 , ((IntLiteral) parser.parseExpr("(20 + 2) / 2").accept(eval)).getValue());
			assertEquals(5 , ((IntLiteral) parser.parseExpr("(5 * 5) / 5)").accept(eval)).getValue());
			assertEquals(5 , ((IntLiteral) parser.parseExpr("25 / (2 + 3)").accept(eval)).getValue());
		}
		
		@Test
		public void testGT() throws ParseError {
			assertEquals(true , ((BoolLiteral) parser.parseExpr("20 > 5").accept(eval)).getValue());
			assertEquals(true , ((BoolLiteral) parser.parseExpr("20.00 > 5.00").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("2 > 5").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("25.00 > 30.00").accept(eval)).getValue());
		}
		
		@Test
		public void testLT() throws ParseError {
			assertEquals(true , ((BoolLiteral) parser.parseExpr("2 < 5").accept(eval)).getValue());
			assertEquals(true , ((BoolLiteral) parser.parseExpr("2.00 < 5.00").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("20 < 5").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("250.00 < 30.00").accept(eval)).getValue());
		}
		
		@Test
		public void testEq() throws ParseError {
			assertEquals(true , ((BoolLiteral) parser.parseExpr("2 == 2").accept(eval)).getValue());
			assertEquals(true , ((BoolLiteral) parser.parseExpr("2.00 == 2.00").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("20 == 5").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("250.00 == 30.00").accept(eval)).getValue());
			assertEquals(true , ((BoolLiteral) parser.parseExpr("true == true").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("true == false").accept(eval)).getValue());
		}
		
		@Test
		public void testNEq() throws ParseError {
			assertEquals(false , ((BoolLiteral) parser.parseExpr("2 != 2").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("2.00 != 2.00").accept(eval)).getValue());
			assertEquals(true , ((BoolLiteral) parser.parseExpr("20 != 5").accept(eval)).getValue());
			assertEquals(true , ((BoolLiteral) parser.parseExpr("250.00 != 30.00").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("true != true").accept(eval)).getValue());
			assertEquals(true , ((BoolLiteral) parser.parseExpr("true != false").accept(eval)).getValue());
		}
		
		@Test
		public void testGEq() throws ParseError {
			assertEquals(true , ((BoolLiteral) parser.parseExpr("5 >= 5").accept(eval)).getValue());
			assertEquals(true , ((BoolLiteral) parser.parseExpr("20.00 >= 20.00").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("4 >= 5").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("25.00 >= 30.00").accept(eval)).getValue());
		}
		
		@Test
		public void testLEq() throws ParseError {
			assertEquals(true , ((BoolLiteral) parser.parseExpr("5 <= 5").accept(eval)).getValue());
			assertEquals(true , ((BoolLiteral) parser.parseExpr("2.00 <= 5.00").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("20 <= 5").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("250.00 <= 30.00").accept(eval)).getValue());
		}
		
		@Test
		public void testNot() throws ParseError {
			assertEquals(true , ((BoolLiteral) parser.parseExpr("!false").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("!true").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("!(true && true)").accept(eval)).getValue());
		}
		
		@Test
		public void testAnd() throws ParseError {
			assertEquals(true , ((BoolLiteral) parser.parseExpr("true && true").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("true && false").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("(3 >5) && (9>10)").accept(eval)).getValue());
		}
		
		@Test
		public void testOr() throws ParseError {
			assertEquals(true , ((BoolLiteral) parser.parseExpr("true || true").accept(eval)).getValue());
			assertEquals(true , ((BoolLiteral) parser.parseExpr("true || false").accept(eval)).getValue());
			assertEquals(false , ((BoolLiteral) parser.parseExpr("(3 >5) || (9>10)").accept(eval)).getValue());
		}
		
}

