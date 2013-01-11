package org.uva.sea.ql.tests.parser.parserTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.Bool;
import org.uva.sea.ql.ast.expr.If;
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
		assertEquals(ArrayList.class, i.getIfBody().getClass());
		assertTrue(i.getElseBody().isEmpty());
	}
	
	@Test
	public void testIfElse() throws ParseError {
		If i = parseIf(ifString + elseString);
		parseElse(i.getElseBody());
	}
	
	@Test
	public void testIfElseif() throws ParseError {
		If i = parseIf(ifString + elseIfStrings);
		List<FormElement> elseBody = parseElseIf(i.getElseBody());
		assertNotNull(elseBody);
		assertTrue(elseBody.isEmpty());		
	}
	
	@Test
	public void testIfElseifElse() throws ParseError {
		If i = parseIf(ifString + elseIfStrings + elseString);
		List<FormElement> elseBody = parseElseIf(i.getElseBody());
		parseElse(elseBody);
	}
	

	private If parseIf(String input) throws ParseError {
		FormElement formElement = parseFormElement(input);
		assertEquals(If.class, formElement.getClass());
		return (If) formElement;
	}

	private void parseElse(List<FormElement> input) {
		assertNotNull(input);
		assertEquals(1, input.size());
		assertEquals(Question.class, input.get(0).getClass());
	}

	private List<FormElement> parseElseIf(List<FormElement> input) {
		for(int i = 0; i < 2; ++i) {
			assertNotNull(input);
			assertEquals(1, input.size());
			assertEquals(If.class, input.get(0).getClass());
			input = ((If) input.get(0)).getElseBody();
		}
		return input;
	}
}
