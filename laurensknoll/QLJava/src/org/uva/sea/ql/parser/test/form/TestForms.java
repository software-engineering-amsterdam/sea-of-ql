package org.uva.sea.ql.parser.test.form;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.parser.test.IParse;
import org.uva.sea.ql.parser.test.ParseError;

@RunWith(Parameterized.class)
public class TestForms {

	private IParse parser;

	@Parameters
	public static List<Object[]> theParsers() {
		List<Object[]> parserList = new ArrayList<Object[]>();
		parserList.add(new Object[] { new Parser() });
		return parserList;
	}

	public TestForms(IParse parser) {
		this.parser = parser;
	}

	@Test
	public void testQuestionFormStatements() throws ParseError {
		assertEquals(Question.class, parser.parse("form Box1House { }")
				.getClass());
	}
}
