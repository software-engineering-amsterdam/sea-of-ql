package org.uva.sea.ql.tests.parser.parserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Add;
import org.uva.sea.ql.parser.ParseError;

import static org.junit.Assert.assertEquals;

public class AddTests extends ParserTests {

	@Test
	public void testAdds() throws ParseError {
		assertEquals(Add.class, parseExpression("a + b").getClass());
		assertEquals(Add.class, parseExpression("a + b + c").getClass());
		assertEquals(Add.class, parseExpression("(a + b + c)").getClass());
		assertEquals(Add.class, parseExpression("a + (b + c)").getClass());
		assertEquals(Add.class, parseExpression("(a + b) + c").getClass());
		assertEquals(Add.class, parseExpression("(a + b)").getClass());
		assertEquals(Add.class, parseExpression("a + b * c").getClass());
		assertEquals(Add.class, parseExpression("a * b + c").getClass());
	}
	
}
