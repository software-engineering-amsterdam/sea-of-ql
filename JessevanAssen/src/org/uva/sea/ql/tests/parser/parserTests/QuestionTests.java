package org.uva.sea.ql.tests.parser.parserTests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.parser.ParseError;

public class QuestionTests extends ParserTests {

	@Test
	public void testQuestion() throws ParseError {
		final String question = "This is the question!",
				     value    = "name",
				     type     = "boolean";
		
		FormElement formElement = parseFormElement(String.format("\"%s\" %s : %s", question, value, type));
		assertEquals(Question.class, formElement.getClass());
		Question q = (Question) formElement;
		
		assertEquals(question, q.getQuestion());
		assertEquals(value,    q.getValue().getName());
		assertEquals(type,     q.getType());
	}
	
}
