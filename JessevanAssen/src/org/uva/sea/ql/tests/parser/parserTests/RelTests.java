package org.uva.sea.ql.tests.parser.parserTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.GT;
import org.uva.sea.ql.ast.expr.LEq;
import org.uva.sea.ql.ast.expr.LT;
import org.uva.sea.ql.parser.ParseError;

public class RelTests extends ParserTests {

	@Test
	public void testRels() throws ParseError {
		assertEquals(LT.class, parseExpression("a < b").getClass());
		assertEquals(LT.class, parseExpression("a < b + c").getClass());
		assertEquals(LT.class, parseExpression("a < (b * c)").getClass());
		assertEquals(LT.class, parseExpression("(a * b) < c").getClass());
		assertEquals(LEq.class, parseExpression("(a <= b)").getClass());
		assertEquals(GT.class, parseExpression("a + b > c").getClass());
		assertEquals(GT.class, parseExpression("a > b + c").getClass());
	}    
	
}
