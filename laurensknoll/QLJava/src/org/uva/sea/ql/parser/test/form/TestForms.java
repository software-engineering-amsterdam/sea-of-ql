package org.uva.sea.ql.parser.test.form;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class TestForms {

	private IParse parser;

	public TestForms() {
		this.parser = new Parser();
	}

	@Test
	public void testQuestionFormStatements() throws ParseError {
		assertEquals(Question.class, parser.parse("form Box1House { }")
				.getClass());
	}
}
