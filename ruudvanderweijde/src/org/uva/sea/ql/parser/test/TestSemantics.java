package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.antlr.tool.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.visitor.checker.ExpressionChecker;

@RunWith(Parameterized.class)
public class TestSemantics {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		Object[][] data = new Object[][] { new Object[] {new ANTLRParser()} };
		return Arrays.asList(data);
	}
	public static HashMap<Ident, Type> ExprMap = new HashMap<Ident, Type>();
	public static ArrayList<Message> errors = new ArrayList<Message>();

	
	public TestSemantics(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testAdd() throws ParseError {
		assertEquals(parser.parseExpression("1+1").accept(new ExpressionChecker(ExprMap, errors)), true);
    	assertEquals(parser.parseExpression("1+true").accept(new ExpressionChecker(ExprMap, errors)), false);	
	}

	@Test
	public void testAnd() throws ParseError {
		assertEquals(parser.parseExpression("true && false").accept(new ExpressionChecker(ExprMap, errors)), true);
    	assertEquals(parser.parseExpression("true && 1").accept(new ExpressionChecker(ExprMap, errors)), true);	
	}

	
	@Test
	public void testBool() throws ParseError {
		assertEquals(parser.parseExpression("true").accept(new ExpressionChecker(ExprMap, errors)), true);
    	assertEquals(parser.parseExpression("false").accept(new ExpressionChecker(ExprMap, errors)), true);	
	}
}
