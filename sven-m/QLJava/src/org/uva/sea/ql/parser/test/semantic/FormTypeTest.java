package org.uva.sea.ql.parser.test.semantic;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.uva.sea.ql.parser.antlr.ParseError;

public class FormTypeTest extends AbstractFormTypeTest {

	@Override
	protected boolean typeCheck(String src) throws ParseError {
		return getParser().parseForm(src).accept(getTypeChecker());
	}

	@Test
	public void testForms() throws ParseError {
		assertTrue(typeCheck("form f1 { q1: \"Question 1\" boolean }"));
		assertTrue(typeCheck("form f2 { q2: \" \" string }"));
		assertTrue(typeCheck("form f3 { }"));
		assertTrue(typeCheck("form f5 { q3: \" \" integer }"));
	}

}
