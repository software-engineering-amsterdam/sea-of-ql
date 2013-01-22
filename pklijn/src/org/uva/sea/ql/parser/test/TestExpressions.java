package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.uva.sea.ql.ast.Add;
import org.uva.sea.ql.ast.GT;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.ast.Int;
import org.uva.sea.ql.ast.LEq;
import org.uva.sea.ql.ast.LT;
import org.uva.sea.ql.ast.Mul;
import org.uva.sea.ql.ast.values.*;
import org.uva.sea.ql.parser.antlr.ANTLRParser;

public class TestExpressions {

	private IParse parser;
	
	public TestExpressions() {
		this.parser = new ANTLRParser();
	}
	
	@Test
	public void testAdds() throws ParseError {
		assertEquals(Add.class, parser.parse("a + b").getClass());
		assertEquals(Add.class, parser.parse("a + b + c").getClass());
		assertEquals(Add.class, parser.parse("(a + b + c)").getClass());
		assertEquals(Add.class, parser.parse("a + (b + c)").getClass());
		assertEquals(Add.class, parser.parse("(a + b) + c").getClass());
		assertEquals(Add.class, parser.parse("(a + b)").getClass());
		assertEquals(Add.class, parser.parse("a + b * c").getClass());
		assertEquals(Add.class, parser.parse("a * b + c").getClass());
	}

	@Test
	public void testMuls() throws ParseError {
		assertEquals(Mul.class, parser.parse("a * b").getClass());
		assertEquals(Mul.class, parser.parse("a * b * c").getClass());
		assertEquals(Mul.class, parser.parse("a * (b * c)").getClass());
		assertEquals(Mul.class, parser.parse("(a * b) * c").getClass());
		assertEquals(Mul.class, parser.parse("(a * b)").getClass());
		assertEquals(Mul.class, parser.parse("(a + b) * c").getClass());
		assertEquals(Mul.class, parser.parse("a * (b + c)").getClass());
	}
	
	@Test
	public void testRels() throws ParseError {
		assertEquals(LT.class, parser.parse("a < b").getClass());
		assertEquals(LT.class, parser.parse("a < b + c").getClass());
		assertEquals(LT.class, parser.parse("a < (b * c)").getClass());
		assertEquals(LT.class, parser.parse("(a * b) < c").getClass());
		assertEquals(LEq.class, parser.parse("(a <= b)").getClass());
		assertEquals(GT.class, parser.parse("a + b > c").getClass());
		assertEquals(GT.class, parser.parse("a > b + c").getClass());
	}


	@Test
	public void testIds() throws ParseError {
		assertEquals(Ident.class, parser.parse("a").getClass());
		assertEquals(Ident.class, parser.parse("abc").getClass());
		assertEquals(Ident.class, parser.parse("ABC").getClass());
		assertEquals(Ident.class, parser.parse("ABCDEF").getClass());
		assertEquals(Ident.class, parser.parse("abc2323").getClass());
		assertEquals(Ident.class, parser.parse("a2bc232").getClass());
		assertEquals(Ident.class, parser.parse("a2bc232aa").getClass());
	}

	@Test
	public void testNums() throws ParseError {
		assertEquals(Int.class, parser.parse("0").getClass());
		assertEquals(Int.class, parser.parse("1223").getClass());
		assertEquals(Int.class, parser.parse("234234234").getClass());
	}
	
	@Test
	public void testCalculation() throws ParseError {
		assertEquals(
				new Integer(3),
				((IntValue)parser.parse("1 + 2").eval()).getValue());
		assertEquals(
				new Integer(7),
				((IntValue)parser.parse("1 + 2 * 3").eval()).getValue()); 
		assertEquals(
				new Integer(9),
				((IntValue)parser.parse("(1 + 2) * 3").eval()).getValue()); 
		assertEquals(
				new Integer(4),
				((IntValue)parser.parse("(1 + 2) * 3 - (2 + 3)").eval()).getValue());
		assertEquals(
				new Integer(3),
				((IntValue)parser.parse("27 / 3 / 3").eval()).getValue());
		assertEquals(
				new Integer(5),
				((IntValue)parser.parse("(4 * 5) / 4").eval()).getValue());
	}
	
	@Test
	public void testEquation() throws ParseError { // TODO: geen equation noemen..
		assertTrue(((BoolValue)parser.parse("(1 < 2) && (3 < 4)").eval()).getValue());
		assertTrue(((BoolValue)parser.parse("(1 <= 1) && (7 > 4)").eval()).getValue());
		assertTrue(((BoolValue)parser.parse("(1 > 2) || (3 < 4)").eval()).getValue());
		assertFalse(((BoolValue)parser.parse("(1 >= 2) || (3 >= 4)").eval()).getValue());
		
		assertTrue(((BoolValue)parser.parse("10 == 10").eval()).getValue());
		assertTrue(((BoolValue)parser.parse("099 == 99").eval()).getValue());
		assertFalse(((BoolValue)parser.parse("23 == 25").eval()).getValue());
		assertTrue(((BoolValue)parser.parse("-124 == -124").eval()).getValue());
		
		assertTrue(((BoolValue)parser.parse("1 != 2").eval()).getValue());
		assertFalse(((BoolValue)parser.parse("245 != 245").eval()).getValue());
		
		assertTrue(((BoolValue)parser.parse("true == true").eval()).getValue());
		assertTrue(((BoolValue)parser.parse("false == false").eval()).getValue());
		assertFalse(((BoolValue)parser.parse("true == false").eval()).getValue());
		assertFalse(((BoolValue)parser.parse("false == true").eval()).getValue());
		
		assertTrue(((BoolValue)parser.parse("true != false").eval()).getValue());
		assertTrue(((BoolValue)parser.parse("false != true").eval()).getValue());
		assertFalse(((BoolValue)parser.parse("true != true").eval()).getValue());
		assertFalse(((BoolValue)parser.parse("false != false").eval()).getValue());
		
		assertTrue(((BoolValue)parser.parse("\"peter\" == \"peter\"").eval()).getValue());
		assertFalse(((BoolValue)parser.parse("\"peter\" == \"klijn\"").eval()).getValue());
		assertTrue(((BoolValue)parser.parse("\"peter\" != \"klijn\"").eval()).getValue());
		assertFalse(((BoolValue)parser.parse("\"peter\" != \"peter\"").eval()).getValue());		
	}
}
