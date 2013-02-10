package org.uva.sea.ql.tests.semantic.expression;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.tests.IParse;
import org.uva.sea.ql.visitor.ExpressionTypeVisitor;
import org.uva.sea.ql.visitor.SymbolTable;

@RunWith(Parameterized.class)
public class TestBinary {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		Object[][] data = new Object[][] { new Object[] {new ANTLRParser()} };
		return Arrays.asList(data);
	}
	public static SymbolTable symbolTable = new SymbolTable();
	public static ArrayList<Message> errors = new ArrayList<Message>();

	
	public TestBinary(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testAdd() throws ParseError {
		assertTrue(parser.parseExpression("1 + 1").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("1 + true").accept(new ExpressionTypeVisitor(symbolTable, errors)));	
	}

	@Test
	public void testAnd() throws ParseError {
		assertTrue(parser.parseExpression("true && false").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("true && 1").accept(new ExpressionTypeVisitor(symbolTable, errors)));	
	}

	@Test
	public void testDiv() throws ParseError {
		assertTrue(parser.parseExpression("2 - 1").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("2 - true").accept(new ExpressionTypeVisitor(symbolTable, errors)));	
	}
	
	@Test
	public void testEq() throws ParseError {
		assertTrue(parser.parseExpression("true == true").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("true == 1").accept(new ExpressionTypeVisitor(symbolTable, errors)));
    	
		assertTrue(parser.parseExpression("1 == 10").accept(new ExpressionTypeVisitor(symbolTable, errors)));
    	assertFalse(parser.parseExpression("true == 1").accept(new ExpressionTypeVisitor(symbolTable, errors)));
	}
	
	@Test
	public void testGT() throws ParseError {
		assertTrue(parser.parseExpression("10 > 1").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("10 > true").accept(new ExpressionTypeVisitor(symbolTable, errors)));	
	}
	
	@Test
	public void testGEq() throws ParseError {
		assertTrue(parser.parseExpression("1 >= 3").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("1 >= true").accept(new ExpressionTypeVisitor(symbolTable, errors)));	
	}
	
	@Test
	public void testLEq() throws ParseError {
		assertTrue(parser.parseExpression("1 <= 10").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("1 <= true").accept(new ExpressionTypeVisitor(symbolTable, errors)));	
	}	
	
	@Test
	public void testLT() throws ParseError {
		assertTrue(parser.parseExpression("1 < 10").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("1 < true").accept(new ExpressionTypeVisitor(symbolTable, errors)));	
	}
	
	@Test
	public void testMul() throws ParseError {
		assertTrue(parser.parseExpression("1 * 10").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("1 * true").accept(new ExpressionTypeVisitor(symbolTable, errors)));	
	}	
	
	@Test
	public void testNEq() throws ParseError {
		assertTrue(parser.parseExpression("true != true").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("true != 1").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		
		assertTrue(parser.parseExpression("10 != 1").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("true != 1").accept(new ExpressionTypeVisitor(symbolTable, errors)));
	}
	
	@Test
	public void testOr() throws ParseError {
		assertTrue(parser.parseExpression("true || false").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("1 || true").accept(new ExpressionTypeVisitor(symbolTable, errors)));	
	}
	
	@Test
	public void testSub() throws ParseError {
		assertTrue(parser.parseExpression("10 / 1").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("10 / true").accept(new ExpressionTypeVisitor(symbolTable, errors)));	
	}
}