package org.uva.sea.ql.tests.semantic.expression;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
public class TestUnary {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		Object[][] data = new Object[][] { new Object[] {new ANTLRParser()} };
		return Arrays.asList(data);
	}
	public static SymbolTable symbolTable = new SymbolTable();
	public static ArrayList<Message> errors = new ArrayList<Message>();

	
	public TestUnary(IParse parser) {
		this.parser = parser;
	}
	
	@Test
	public void testNeg() throws ParseError {
		assertTrue(parser.parseExpression("-1").accept(new ExpressionTypeVisitor(symbolTable, errors)));
    	assertFalse(parser.parseExpression("+true").accept(new ExpressionTypeVisitor(symbolTable, errors)));	
	}

	@Test
	public void testNot() throws ParseError {
		assertTrue(parser.parseExpression("!true").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("!1").accept(new ExpressionTypeVisitor(symbolTable, errors)));	
	}
	
	@Test
	public void testPos() throws ParseError {
		assertTrue(parser.parseExpression("+1").accept(new ExpressionTypeVisitor(symbolTable, errors)));
		assertFalse(parser.parseExpression("+true").accept(new ExpressionTypeVisitor(symbolTable, errors)));	
	}
}
