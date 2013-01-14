package org.uva.sea.ql.parser.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.nodetypes.formelements.Question;
import org.uva.sea.ql.parser.exception.ParseError;

public class TestFormElements extends TestParser {

	@Test
	public void testQuestions() throws ParseError {
		
		assertEquals(Question.class, parseStatement("ageCheck : \"Are you 18 years or older?\" boolean").getClass());
	}
}
