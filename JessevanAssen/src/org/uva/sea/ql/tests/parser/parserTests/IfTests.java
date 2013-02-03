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
        FormElement formElement = parseFormElement(ifString);
        assertEquals(If.class, formElement.getClass());
	}
	
	@Test
	public void testIfElse() throws ParseError {
        FormElement formElement = parseFormElement(ifString + elseString);
        assertEquals(IfElse.class, formElement.getClass());
        assertEquals(Question.class, ((IfElse)formElement).getElseBody().getClass());
	}
	
	@Test
	public void testIfElseif() throws ParseError {
        FormElement formElement = parseFormElement(ifString + elseIfStrings);
        assertEquals(IfElse.class, formElement.getClass());
        formElement = ((IfElse)formElement).getElseBody();
        assertEquals(IfElse.class, formElement.getClass());
        formElement = ((IfElse)formElement).getElseBody();
        assertEquals(If.class, formElement.getClass());
	}
	
	@Test
	public void testIfElseifElse() throws ParseError {
        FormElement formElement = parseFormElement(ifString + elseIfStrings + elseString);
        assertEquals(IfElse.class, formElement.getClass());
        formElement = ((IfElse)formElement).getElseBody();
        assertEquals(IfElse.class, formElement.getClass());
        formElement = ((IfElse)formElement).getElseBody();
        assertEquals(IfElse.class, formElement.getClass());
        formElement = ((IfElse)formElement).getElseBody();
        assertEquals(Question.class, formElement.getClass());
    }
}
