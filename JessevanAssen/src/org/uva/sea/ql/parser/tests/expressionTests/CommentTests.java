package org.uva.sea.ql.parser.tests.expressionTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Ident;
import org.uva.sea.ql.parser.ParseError;

public class CommentTests extends ExpressionTests {

	@Test
	public void testMultilineComments() throws ParseError {
		assertEquals(Ident.class, parser.parse("/* ... */ a").getClass());
	}
	
	@Test
	public void testSinglelineComments() throws ParseError {
		assertEquals(Ident.class, parser.parse("// ... \n a").getClass());
	}
	
}
