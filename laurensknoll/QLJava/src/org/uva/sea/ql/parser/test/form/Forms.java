package org.uva.sea.ql.parser.test.form;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

public class Forms {

	private IParse parser;

	public Forms() {
		this.parser = new Parser();
	}

	@Test
	public void questionForms() throws ParseError {
		assertEquals(Question.class, parser.parse("form Box1House { }")
				.getClass());
	}
}
