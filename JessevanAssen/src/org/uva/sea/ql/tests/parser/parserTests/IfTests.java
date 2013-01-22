package org.uva.sea.ql.tests.parser.parserTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.Ident;
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
	

	private IfElse parseIfElse(String input) throws ParseError {
		FormElement formElement = parseFormElement(input);
		assertEquals(IfElse.class, formElement.getClass());
        IfElse i = (IfElse) formElement;
		assertEquals(Bool.class, i.getCondition().getClass());
		assertEquals(Question.class, i.getIfBody().getClass());
		assertEquals(new Ident("a"), ((Question)i.getIfBody()).getIdentifier());
		return i;
	}

	private void parseElse(FormElement formElement) {
		assertNotNull(formElement);
		assertEquals(Question.class, formElement.getClass());
		assertEquals(new Ident("d"), ((Question)formElement).getIdentifier());

	}

	private FormElement parseElseIf(FormElement formElement) {
		final Ident[] identities = {
                new Ident("b"),
                new Ident("c")
        };

        for(int i = 0; i < 2; ++i) {
			assertNotNull(formElement);
			assertEquals(IfElse.class, formElement.getClass());
            IfElse ifElement = (IfElse) formElement;
            assertEquals(Question.class, ifElement.getIfBody().getClass());
            assertEquals(identities[i], ((Question)ifElement.getIfBody()).getIdentifier());
			formElement = ifElement.getElseBody();
		}
		return formElement;
	}
}
