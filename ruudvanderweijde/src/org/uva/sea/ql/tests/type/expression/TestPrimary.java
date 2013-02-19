package org.uva.sea.ql.tests.type.expression;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.visitor.typeCheck.ExpressionTypeVisitor;
import org.uva.sea.ql.visitor.typeCheck.TypeMapper;

public class TestPrimary {
	private final IParse parser = new ANTLRParser();
	public static TypeMapper typeMapper = new TypeMapper();
	public static ArrayList<Message> errors = new ArrayList<Message>();

	@Test
	public void testBool() throws ParseError {
		assertTrue(isValidExpression("true"));
		assertTrue(isValidExpression("false"));	
	}

	@Test
	public void testString() throws ParseError {
		assertTrue(isValidExpression("\"ident1\""));
		assertTrue(isValidExpression("\"validident\""));
		assertTrue(isValidExpression("\"This is a line\""));
		assertTrue(isValidExpression("\"This is a line\r\nWith breaks\""));
	}

	@Test
	public void testIdent() throws ParseError {
		assertTrue(isValidExpression("ident1"));
		assertTrue(isValidExpression("validident"));	
		assertTrue(isValidExpression("validi_dent"));	
	}
	
	@Test
	public void testInt() throws ParseError {
		assertTrue(isValidExpression("1"));
		assertTrue(isValidExpression("10"));
    	assertTrue(isValidExpression("100"));
    	assertTrue(isValidExpression("-100"));
	}	
	
	private boolean isValidExpression(String expression) throws ParseError {
		return parser.parseExpression(expression).accept(new ExpressionTypeVisitor(typeMapper, errors));
	}
}
