package org.uva.sea.ql.parser.tests.parserTests;

import org.junit.Test;
import static org.junit.Assert.*;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.ParseError;

public class FormTests extends ParserTests {

	@Test
	public void testEmptyForm() throws ParseError {
		final String formName = "awesomeForm";
		ASTNode parsed = parser.parse(String.format("form %s { }", formName));
		
		assertEquals(Form.class, parsed.getClass());
		
		Form form = (Form) parsed;
		assertEquals(formName, form.getName().getName());
		assertNotNull(form.getBody());
		assertEquals(0, form.getBody().size());
	}
	
	@Test
	public void testFilledForm() throws ParseError {
		final String formName = "awesomeForm";
		ASTNode parsed = parser.parse(String.format(
				"form %s { " +
						"\"Favorite flavor of bread?\" bread : string " +
						"\"Favorite flavor of cheese?\" cheese : string " +
						"\"Favorite flavor of candy?\" candy : string " +
				"}", formName));
		
		assertEquals(Form.class, parsed.getClass());
		
		Form form = (Form) parsed;
		assertEquals(formName, form.getName().getName());
		assertNotNull(form.getBody());
		assertEquals(3, form.getBody().size());
	}
}
