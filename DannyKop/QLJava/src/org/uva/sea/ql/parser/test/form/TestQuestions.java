package org.uva.sea.ql.parser.test.form;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.StrType;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.parser.test.TestParser;

public class TestQuestions extends TestParser {

	@Test
	public void acceptsCorrectInputTypeBool() throws ParseError {
		FormElement q = parseFormElement("isOk: \"Is it ok?\" boolean");
		assertEquals(Question.class, q.getClass());
		assertEquals(((Question)q).getType().getClass(), BoolType.class);
	}
	@Test
	public void acceptsCorrectInputTypeInt() throws ParseError {
		FormElement q = parseFormElement("age: \"Enter you age\" int");
		assertEquals(Question.class, q.getClass());
		assertEquals(((Question)q).getType().getClass(), IntType.class);
	}
	@Test
	public void acceptsCorrectInputTypeString() throws ParseError {
		FormElement q = parseFormElement("name: \"Enter you name\" string");
		assertEquals(Question.class, q.getClass());
		assertEquals(((Question)q).getType().getClass(), StrType.class);
	}
}
