package org.uva.sea.ql.parser.test.semantic.expression;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.expr.primary.Ident;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.visitor.checker.ExpressionVisitor;

@RunWith(Parameterized.class)
public class TestPrimary {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		Object[][] data = new Object[][] { new Object[] {new ANTLRParser()} };
		return Arrays.asList(data);
	}
	public static HashMap<Ident, Type> ExprMap = new HashMap<Ident, Type>();
	public static ArrayList<String> errors = new ArrayList<String>();

	
	public TestPrimary(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testBool() throws ParseError {
		assertEquals(parser.parseExpression("true").accept(new ExpressionVisitor(ExprMap, errors)), true);
    	assertEquals(parser.parseExpression("false").accept(new ExpressionVisitor(ExprMap, errors)), true);	
	}

	@Test
	public void testIdent() throws ParseError {
		assertEquals(parser.parseExpression("ident1").accept(new ExpressionVisitor(ExprMap, errors)), true);
    	assertEquals(parser.parseExpression("validident").accept(new ExpressionVisitor(ExprMap, errors)), true);	
	}
	
	@Test
	public void testInt() throws ParseError {
		assertEquals(parser.parseExpression("1").accept(new ExpressionVisitor(ExprMap, errors)), true);
    	assertEquals(parser.parseExpression("100").accept(new ExpressionVisitor(ExprMap, errors)), true);	
	}	
}
