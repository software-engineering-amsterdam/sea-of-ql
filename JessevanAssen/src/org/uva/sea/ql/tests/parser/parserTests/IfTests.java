package org.uva.sea.ql.tests.parser.parserTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.ParseError;

public class IfTests extends ParserTests {

	private final String ifString =
			"if(true) { " +
				"\"a\" a : boolean " +
			"}";
	private final String elseIfStrings = 
			"else if(true) { " +
				"\"b\" b : boolean " +
			"} else if(true) { " +
				"\"c\" c : boolean " +
			"}";
	private final String elseString =
			"else { " +
				"\"d\" d : boolean " +
			"}";
	@Test
	public void testLonelyIf() throws ParseError {
        Statement statement = parseStatement(ifString);
        assertEquals(If.class, statement.getClass());
	}
	
	@Test
	public void testIfElse() throws ParseError {
        Statement statement = parseStatement(ifString + elseString);
        assertEquals(IfElse.class, statement.getClass());
        assertEquals(Question.class, ((IfElse) statement).getElseBody().getClass());
	}
	
	@Test
	public void testIfElseif() throws ParseError {
        Statement statement = parseStatement(ifString + elseIfStrings);
        assertEquals(IfElse.class, statement.getClass());
        statement = ((IfElse) statement).getElseBody();
        assertEquals(IfElse.class, statement.getClass());
        statement = ((IfElse) statement).getElseBody();
        assertEquals(If.class, statement.getClass());
	}
	
	@Test
	public void testIfElseifElse() throws ParseError {
        Statement statement = parseStatement(ifString + elseIfStrings + elseString);
        assertEquals(IfElse.class, statement.getClass());
        statement = ((IfElse) statement).getElseBody();
        assertEquals(IfElse.class, statement.getClass());
        statement = ((IfElse) statement).getElseBody();
        assertEquals(IfElse.class, statement.getClass());
        statement = ((IfElse) statement).getElseBody();
        assertEquals(Question.class, statement.getClass());
    }
}
