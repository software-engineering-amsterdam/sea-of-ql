package org.uva.sea.ql.parser.tests.expressionTests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.ast.Int;
import org.uva.sea.ql.parser.ParseError;

public class IntTests extends ExpressionTests {

	@Test
	public void testInts() throws ParseError {
		assertEquals(Int.class, parser.parse("0").getClass());
		assertEquals(Int.class, parser.parse("1223").getClass());
		assertEquals(Int.class, parser.parse("234234234").getClass());
	}
	
}
