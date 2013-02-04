package org.uva.sea.ql.tests.parser.parserTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.parser.ParseError;

public class CommentTests extends ParserTests {

	@Test
	public void testMultilineComments() throws ParseError {
		assertEquals(Question.class, parseStatement("/* ... */ \"a\" c : boolean").getClass());
	}
	
	@Test
	public void testSinglelineComments() throws ParseError {
		assertEquals(Question.class, parseStatement("// ... \n \"a\" c : boolean").getClass());
	}
	
}
