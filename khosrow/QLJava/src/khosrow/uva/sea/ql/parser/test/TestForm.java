package khosrow.uva.sea.ql.parser.test;

import static org.junit.Assert.*;


import khosrow.uva.sea.ql.ast.decl.Form;
import khosrow.uva.sea.ql.parser.jacc.JACCParser;

import org.junit.Before;
import org.junit.Test;

public class TestForm {
	private IParse parser;
	
	@Before
	public void setup(){
		parser = new JACCParser();
	}
	
	@Test
	public void testForm() throws ParseError{		
		assertEquals(parser.ParseForm("form f1 {}".toString()).getClass(), Form.class);
		assertEquals(parser.ParseForm("form f2 { Q1: \"Ask a question?\" boolean }").getClass(), Form.class);
		assertEquals(parser.ParseForm("form f3 { Q2 (a + B): \"Ask a question?\" boolean }").getClass(), Form.class);
		assertEquals(parser.ParseForm("form f3 { if (a - b > c) { Q3 (a + B): \"Ask a question?\" boolean }}").getClass(), Form.class);
	}
}
