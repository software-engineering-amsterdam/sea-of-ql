package org.uva.sea.ql.parser.tests.parserTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.parser.ParseError;

public class CommentTests extends ParserTests {

	@Test
	public void testMultilineComments() throws ParseError {
		assertEquals(Question.class, parseFormElement("/* ... */ \"a\" c : boolean").getClass());
	}
	
	@Test
	public void testSinglelineComments() throws ParseError {
		assertEquals(Question.class, parseFormElement("// ... \n \"a\" c : boolean").getClass());
	}
	
}
