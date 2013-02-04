package org.uva.sea.ql.tests.parser.parserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.parser.ParseError;

import static org.junit.Assert.assertEquals;

public class QuestionTests extends ParserTests {

	@Test
	public void testQuestion() throws ParseError {
		final String question = "This is the question!",
				     value    = "name",
				     type     = "boolean";
		
		Statement statement = parseStatement(String.format("\"%s\" %s : %s", question, value, type));
		assertEquals(Question.class, statement.getClass());
		Question q = (Question) statement;
		
		assertEquals(question, q.getQuestion());
		assertEquals(value, q.getIdentifier().getName());
		assertEquals(org.uva.sea.ql.ast.type.Bool.class, q.getType().getClass());
	}
	
}
