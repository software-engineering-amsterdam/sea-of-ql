package org.uva.sea.ql.parser.test.types;

import static org.junit.Assert.*;
import org.junit.Test;
import org.uva.sea.ql.ast.form.FormElement;
import org.uva.sea.ql.parser.test.ParseError;
import org.uva.sea.ql.parser.test.TestParser;
import org.uva.sea.ql.ast.form.*;
import org.uva.sea.ql.ast.types.StrType;

public class TestTypes extends TestParser {

	@Test
	public void stringCorrect() throws ParseError {
		String testStr = "myName: \"Please enter you're name:\" string";
		FormElement fe = parseFormElement(testStr);
		assertEquals(Question.class, fe.getClass());
		Question q = (Question) fe;
		assertEquals(StrType.class, q.getQuestion().getClass());
	}
	
	@Test
	public void booleanCorrect() throws ParseError {
		// Nog niet nodig! Straks voor de  backend
	}
	
	@Test
	public void moneyCorrect() throws ParseError {
		// Nog niet nodig! Straks voor de  backend
	}
	
	@Test
	public void intCorrect() throws ParseError {
		// Nog niet nodig! Straks voor de  backend
	}
	

}
