package khosrow.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;


import khosrow.uva.sea.ql.ast.decl.Form;
import khosrow.uva.sea.ql.parser.jacc.JACCParser;

import org.junit.Before;
import org.junit.Test;

public class TestExpressions {

	private IParse parser;

	@Before
	public void setUp()
	{
		parser = new JACCParser();
	}

	
	@Test
	public void testForm() throws ParseError {
		StringBuilder sb = new StringBuilder();
		sb.append("FORM f1 {");
		sb.append("}");
		
		assertEquals(parser.parse(sb.toString()).getClass(), Form.class);
	}
}
