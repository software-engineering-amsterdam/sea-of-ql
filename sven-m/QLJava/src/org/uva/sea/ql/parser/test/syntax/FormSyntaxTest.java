package org.uva.sea.ql.parser.test.syntax;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.form.Form;
import org.uva.sea.ql.parser.antlr.ParseError;

public class FormSyntaxTest extends SyntaxTest {

	@Override
	protected Class<?> parseClass(String src) throws ParseError {
		return getParser().parseForm(src).getClass();
	}
	
	@Test
	public void testForms() throws ParseError {
		assertEquals(Form.class, parseClass("form f1 { \n q1: \"Question 1\" boolean }"));
		assertEquals(Form.class, parseClass("form f1 { \n q1: \"Question 1\" boolean }"));
		assertEquals(Form.class, parseClass("form f2 { \n afds: \" \" string }"));
		assertEquals(Form.class, parseClass("form f3 { }"));
		assertEquals(Form.class, parseClass("form f5 { \n d434fw: \" \" integer }"));
	}

}
