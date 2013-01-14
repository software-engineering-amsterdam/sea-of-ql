package org.uva.sea.ql.tests.parser.parserTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.value.Bool;
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
		If i = parseIf(ifString);
		
		assertEquals(Bool.class, i.getCondition().getClass());
		assertEquals(Question.class, i.getIfBody().getClass());
        assertEquals(NullFormElement.class, i.getElseBody().getClass());
	}
	
	@Test
	public void testIfElse() throws ParseError {
		If i = parseIf(ifString + elseString);
		parseElse(i.getElseBody());
	}
	
	@Test
	public void testIfElseif() throws ParseError {
		If i = parseIf(ifString + elseIfStrings);
		FormElement elseBody = parseElseIf(i.getElseBody());
		assertNotNull(elseBody);
		assertEquals(NullFormElement.class, elseBody.getClass());
	}
	
	@Test
	public void testIfElseifElse() throws ParseError {
		If i = parseIf(ifString + elseIfStrings + elseString);
		FormElement elseBody = parseElseIf(i.getElseBody());
		parseElse(elseBody);
	}
	

	private If parseIf(String input) throws ParseError {
		FormElement formElement = parseFormElement(input);
		assertEquals(If.class, formElement.getClass());
		return (If) formElement;
	}

	private void parseElse(FormElement formElement) {
		assertNotNull(formElement);
		assertEquals(Question.class, formElement.getClass());
	}

	private FormElement parseElseIf(FormElement formElement) {
		for(int i = 0; i < 2; ++i) {
			assertNotNull(formElement);
			assertEquals(If.class, formElement.getClass());
			formElement =((If) formElement).getElseBody();
		}
		return formElement;
	}
}
