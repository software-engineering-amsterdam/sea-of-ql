package org.uva.sea.ql.parser.tests.parserTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.ParseError;

public class IfTests extends ParserTests {

	@Test
	public void testLonelyIf() throws ParseError {
		FormElement formElement = parseFormElement("if(true) { }");
		assertEquals(If.class, formElement.getClass());
		If i = (If) formElement;
		
		assertEquals(Bool.class, i.getCondition());
	}
	
}
