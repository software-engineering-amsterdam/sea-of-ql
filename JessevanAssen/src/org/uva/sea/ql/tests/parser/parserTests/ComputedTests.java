package org.uva.sea.ql.tests.parser.parserTests;

import org.junit.Test;
import org.uva.sea.ql.ast.Computed;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expr.value.Bool;
import org.uva.sea.ql.parser.ParseError;

import static org.junit.Assert.assertEquals;

public class ComputedTests extends ParserTests {

	@Test
	public void testComputed() throws ParseError {
		final String label = "All ways lead to Rome.";
		Statement parsed = parseStatement(String.format("\"%s\" true", label));
		assertEquals(Computed.class, parsed.getClass());
		
		Computed computed = (Computed) parsed;
		assertEquals(label, computed.getLabel());
		assertEquals(Bool.class, computed.getExpression().getClass());
	}
	
}
