package org.uva.sea.ql.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.JACCParser;

public class FormTest {

	private IParse parser;

	@Before
	public void setUp() {
		parser = new JACCParser();
	}

	@Test
	public void testForm() throws ParseError {
		assertEquals(
				Form.class,
				parser.parse(
						"form someForm { Boolean question1 = \"Are you married?\" ; }")
						.getClass());
	}

	@Test(expected = RuntimeException.class)
	public void testEndlessStringLiteral() throws ParseError {
		assertEquals(
				Form.class,
				parser.parse(
						"form someForm { Boolean question1 = \"Are you married? }")
						.getClass());
	}

	@Test
	public void testQuestion() throws ParseError {
		assertEquals(Question.class,
				parser.parse("Boolean q2 = \"How is life?\"; ").getClass());
	}

	@Test
	public void testFormWithIf() throws ParseError {

		String form = "form someForm { "
				+ "Boolean question1 = \"Are you married?\"; "
				+ "Integer money =1; " + "if(question1) { Integer money = 5; "
				+ "Money presentCash = 1000;" + "}" + "}";

		assertEquals(Form.class, parser.parse(form).getClass());

	}
}
