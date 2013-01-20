package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.form.QuestionForm;
import org.uva.sea.ql.parser.antlr.FormParser;

@RunWith(Parameterized.class)
public class TestForms {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> parserList = new ArrayList<Object[]>();
		parserList.add(new Object[] { new FormParser() });
		return parserList;
	}

	public TestForms(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testQuestionFormStatements() throws ParseError {
		assertEquals(QuestionForm.class, parser.parse("form Box1House { }")
				.getClass());
	}
}
