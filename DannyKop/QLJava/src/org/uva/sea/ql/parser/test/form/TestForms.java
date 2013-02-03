package org.uva.sea.ql.parser.test.form;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.visitor.SymbolTable;
import org.uva.sea.ql.parser.test.*;

public class TestForms extends TestParser {
	
	@Test 
	public void emptyForms() throws ParseError {
		String testString = "form naamVanForm {}";
		assertTrue(parseForm(testString).getElements().size() == 0);
	}
	
	@Test (expected = ParseError.class) 
	public void noFormIdent() throws ParseError {
		String testString = "form {}";
		assertEquals(Form.class, parseForm(testString).getClass());
	}
	
	@Test
	public void formWithQuestion() throws ParseError {
		String testString = "form naam { naam: \"Wat is uw naam?\" string } ";
		Form f = parseForm(testString);
		
		assertEquals(Question.class, f.getElements().get(0).getClass());
		assertEquals(((Question)f.getElements().get(0)).getIdent().getName(), "naam" );
		assertEquals(((Question)f.getElements().get(0)).getQuestion().getValue(), "\"Wat is uw naam?\"" );
		assertEquals(((Question)f.getElements().get(0)).getType(new SymbolTable()), "string" );
	}
}
