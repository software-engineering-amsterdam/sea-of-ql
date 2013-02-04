package org.uva.sea.ql.parser.test.form;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.Bool;
import org.uva.sea.ql.ast.types.Int;
import org.uva.sea.ql.ast.types.Money;
import org.uva.sea.ql.ast.types.Str;
import org.uva.sea.ql.ast.visitor.SymbolTable;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.parser.test.TestParser;

public class TestQuestions extends TestParser {

	@Test
	public void acceptsCorrectInputTypeBool() throws ParseError {
		FormElement q = parseFormElement("isOk: \"Is it ok?\" boolean");
		assertEquals(Question.class, q.getClass());
		assertEquals(((Question)q).getType(new SymbolTable()).getClass(), Bool.class);
	}
	@Test
	public void acceptsCorrectInputTypeMoney() throws ParseError {
		FormElement q = parseFormElement("salary: \"Enter you salary\" money");
		assertEquals(Question.class, q.getClass());
		assertEquals(((Question)q).getType(new SymbolTable()).getClass(), Money.class);
	}
	@Test
	public void acceptsCorrectInputTypeInt() throws ParseError {
		FormElement q = parseFormElement("age: \"Enter you age\" int");
		assertEquals(Question.class, q.getClass());
		assertEquals(((Question)q).getType(new SymbolTable()).getClass(), Int.class);
	}
	@Test
	public void acceptsCorrectInputTypeString() throws ParseError {
		FormElement q = parseFormElement("name: \"Enter you name\" string");
		assertEquals(Question.class, q.getClass());
		assertEquals(((Question)q).getType(new SymbolTable()).getClass(), Str.class);
	}
}
