package org.uva.sea.ql.tests.parser.parserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.GreaterThan;
import org.uva.sea.ql.ast.expression.LesserThan;
import org.uva.sea.ql.ast.expression.LesserThanOrEqualTo;
import org.uva.sea.ql.parser.ParseError;

import static org.junit.Assert.assertEquals;

public class RelTests extends ParserTests {

	@Test
	public void testRels() throws ParseError {
		assertEquals(LesserThan.class, parseExpression("a < b").getClass());
		assertEquals(LesserThan.class, parseExpression("a < b + c").getClass());
		assertEquals(LesserThan.class, parseExpression("a < (b * c)").getClass());
		assertEquals(LesserThan.class, parseExpression("(a * b) < c").getClass());
		assertEquals(LesserThanOrEqualTo.class, parseExpression("(a <= b)").getClass());
		assertEquals(GreaterThan.class, parseExpression("a + b > c").getClass());
		assertEquals(GreaterThan.class, parseExpression("a > b + c").getClass());
	}    
	
}
