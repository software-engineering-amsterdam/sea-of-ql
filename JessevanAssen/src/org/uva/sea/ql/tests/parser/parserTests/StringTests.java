package org.uva.sea.ql.tests.parser.parserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.value.Str;
import org.uva.sea.ql.parser.ParseError;

import static org.junit.Assert.assertEquals;

public class StringTests extends ParserTests {
	
	@Test
	public void testString() throws ParseError {
		testString("Henk de Vries!");
	}
	
	@Test
	public void testStringWithEscapedQuote() throws ParseError {
		testString("imma firin mah \\\"LASER\\\"");		
	}

    @Test
    public void testStringWithEscapedBackslash() throws ParseError {
        testString("First part \\\\\" Second part");
    }
	
	private void testString(String stringValue) throws ParseError {
		Expr parsed = parseExpression(String.format("\"%s\"", stringValue));
		assertEquals(Str.class, parsed.getClass());
		assertEquals(stringValue, ((Str) parsed).getValue());
	}
	
}
