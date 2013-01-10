package org.uva.sea.ql.parser.tests.parserTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.ParseError;

public class IfTests extends ParserTests {

	@Test
	public void testLonelyIf() throws ParseError {
		If i = parseIf("if(true) { \"a\" a : boolean }");
		
		assertEquals(Bool.class, i.getCondition().getClass());
		assertEquals(ArrayList.class, i.getIfBody().getClass());
		assertTrue(i.getElseBody().isEmpty());
	}
	
	@Test
	public void testIfElse() throws ParseError {
		If i = parseIf(
			"if(true) { " +
				"\"a\" a : boolean " +
			"} else { " +
				"\"b\" b : boolean " +
			"}");
		
		assertEquals(Bool.class, i.getCondition().getClass());
		assertEquals(ArrayList.class, i.getIfBody().getClass());
		assertFalse(i.getElseBody().isEmpty());
		assertEquals(ArrayList.class, i.getElseBody().getClass());
	}
	
	@Test
	public void testIfElseif() throws ParseError {
		If i = parseIf(
			"if(true) { " +
				"\"a\" a : boolean " +
			"} else if(true) { " +
				"\"b\" b : boolean " +
			"} else if(true) { " +
				"\"c\" c : boolean " +
			"}");
		
		for(int j = 0; j < 2; ++j) {
			assertNotNull(i.getElseBody());
			assertEquals(1, i.getElseBody().size());
			assertEquals(If.class, i.getElseBody().get(0).getClass());
			i = (If) i.getElseBody().get(0);
			assertEquals(Bool.class, i.getCondition().getClass());
			assertEquals(ArrayList.class, i.getIfBody().getClass());
		}
	}
	
	@Test
	public void testIfElseifElse() throws ParseError {
		If i = parseIf(
				"if(true) { " +
					"\"a\" a : boolean " +
				"} else if(true) { " +
					"\"b\" b : boolean " +
				"} else if(true) { " +
					"\"c\" c : boolean " +
				"} else {" +
					"\"d\" d : boolean " +
				"}");
		
		for(int j = 0; j < 2; ++j) {
			assertNotNull(i.getElseBody());
			assertEquals(1, i.getElseBody().size());
			assertEquals(If.class, i.getElseBody().get(0).getClass());
			i = (If) i.getElseBody().get(0);
			assertEquals(Bool.class, i.getCondition().getClass());
			assertEquals(ArrayList.class, i.getIfBody().getClass());
		}
		
		assertNotNull(i.getElseBody());
		assertEquals(1, i.getElseBody().size());
		assertEquals(Question.class, i.getElseBody().get(0).getClass());
	}
	

	private If parseIf(String input) throws ParseError {
		FormElement formElement = parseFormElement(input);
		assertEquals(If.class, formElement.getClass());
		return (If) formElement;
	}
}
