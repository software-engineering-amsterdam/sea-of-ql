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
		
		assertEquals(parser.ParseForm("FORM f1 {}".toString()).getClass(), Form.class);
		
	}
	

}
