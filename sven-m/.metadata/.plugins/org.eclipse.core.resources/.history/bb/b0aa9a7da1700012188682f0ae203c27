package org.uva.sea.ql.parser.test.syntax;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.test.ParseError;

public class FormTest extends SyntaxTest {

	@Override
	protected Class<?> parseClass(String src) throws ParseError {
		return getParser().parseForm(src).getClass();
	}
	
	@Test
	public void testForms() throws ParseError {
		assertEquals(parseClass("form f1 { \n q1: \"Question 1\" boolean }"), Form.class);
		assertEquals(parseClass("form f1 { \n q1: \"Question 1\" boolean }"), Form.class);
		assertEquals(parseClass("form f2 { \n afds: \" \" string }"), Form.class);
		assertEquals(parseClass("form f3 { }"), Form.class);
		assertEquals(Form.class, parseClass("form f5 { \n d434fw: \" \" integer }"));
	}

}
