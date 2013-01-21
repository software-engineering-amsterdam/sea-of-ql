package org.uva.sea.ql.parser.test.form;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.parser.test.TestParser;

public class TestQuestions extends TestParser {

	@Test
	public void acceptsCorrectInputTypeBool() throws ParseError {
		FormElement q = parseFormElement("isOk: \"Is it ok?\" boolean");
		assertEquals(Question.class, q.getClass());
		assertTrue(((Question)q).getType().equals("boolean"));
	}
	@Test
	public void acceptsCorrectInputTypeMoney() throws ParseError {
		FormElement q = parseFormElement("salary: \"Enter you salary\" money");
		assertEquals(Question.class, q.getClass());
		assertTrue(((Question)q).getType().equals("money"));
	}
	@Test
	public void acceptsCorrectInputTypeInt() throws ParseError {
		FormElement q = parseFormElement("age: \"Enter you age\" int");
		assertEquals(Question.class, q.getClass());
		assertTrue(((Question)q).getType().equals("int"));
	}
	@Test
	public void acceptsCorrectInputTypeString() throws ParseError {
		FormElement q = parseFormElement("name: \"Enter you name\" string");
		assertEquals(Question.class, q.getClass());
		assertTrue(((Question)q).getType().equals("string"));
	}
}
