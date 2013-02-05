package org.uva.sea.ql.tests.semantic.expression;

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
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.tests.IParse;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.ExpressionTypeVisitor;

@RunWith(Parameterized.class)
public class TestPrimary {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		Object[][] data = new Object[][] { new Object[] {new ANTLRParser()} };
		return Arrays.asList(data);
	}
	public static HashMap<Ident, Type> exprMap = new HashMap<Ident, Type>();
	public static ArrayList<Message> errors = new ArrayList<Message>();

	
	public TestPrimary(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testBool() throws ParseError {
		assertEquals(parser.parseExpression("true").accept(new ExpressionTypeVisitor(exprMap, errors)), true);
    	assertEquals(parser.parseExpression("false").accept(new ExpressionTypeVisitor(exprMap, errors)), true);	
	}

	@Test
	public void testIdent() throws ParseError {
		assertEquals(parser.parseExpression("ident1").accept(new ExpressionTypeVisitor(exprMap, errors)), true);
    	assertEquals(parser.parseExpression("validident").accept(new ExpressionTypeVisitor(exprMap, errors)), true);	
	}
	
	@Test
	public void testInt() throws ParseError {
		assertEquals(parser.parseExpression("1").accept(new ExpressionTypeVisitor(exprMap, errors)), true);
    	assertEquals(parser.parseExpression("100").accept(new ExpressionTypeVisitor(exprMap, errors)), true);	
	}	
}
