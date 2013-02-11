package org.uva.sea.ql.tests.parser.parserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.value.Int;
import org.uva.sea.ql.parser.ParseError;

import static org.junit.Assert.assertEquals;

public class IntTests extends ParserTests {

	@Test
	public void testInts() throws ParseError {
		assertEquals(Int.class, parseExpression("0").getClass());
		assertEquals(Int.class, parseExpression("1223").getClass());
		assertEquals(Int.class, parseExpression("234234234").getClass());
	}
	
}
