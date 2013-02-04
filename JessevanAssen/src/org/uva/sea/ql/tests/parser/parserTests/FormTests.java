package org.uva.sea.ql.tests.parser.parserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.CompositeStatement;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.NullStatement;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.parser.ParseError;

import java.util.Iterator;

import static org.junit.Assert.*;

public class FormTests extends ParserTests {

	@Test
	public void testEmptyForm() throws ParseError {
		final String formName = "awesomeForm";
		Form form = parser.parse(String.format("form %s { }", formName));

		assertEquals(formName, form.getName().getName());
		assertNotNull(form.getBody());
		assertEquals(NullStatement.class, form.getBody().getClass());
	}
	
	@Test
	public void testFilledForm() throws ParseError {
		final String formName = "awesomeForm";
        Form form = parser.parse(String.format(
				"form %s { " +
						"\"Favorite flavor of bread?\" bread : string " +
						"\"Favorite flavor of cheese?\" cheese : string " +
						"\"Favorite flavor of candy?\" candy : string " +
				"}", formName));

		assertEquals(formName, form.getName().getName());
		assertNotNull(form.getBody());
        assertEquals(CompositeStatement.class, form.getBody().getClass());
        Iterator<Statement> statementIterator = ((CompositeStatement)form.getBody()).getStatements().iterator();
		for(int i = 0; i < 3; ++i) {
            assertTrue(statementIterator.hasNext());
            statementIterator.next();
        }
        assertFalse(statementIterator.hasNext());
	}
}
