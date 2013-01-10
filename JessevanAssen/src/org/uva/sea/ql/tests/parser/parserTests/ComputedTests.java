package org.uva.sea.ql.tests.parser.parserTests;

import static org.junit.Assert.assertEquals;   

import org.junit.Test;                         
import org.uva.sea.ql.ast.*;                 
import org.uva.sea.ql.parser.ParseError;       

public class ComputedTests extends ParserTests {

	@Test
	public void testComputed() throws ParseError {
		final String label = "All ways lead to Rome.";
		ASTNode parsed = parseFormElement(String.format("\"%s\" true", label));
		assertEquals(Computed.class, parsed.getClass());
		
		Computed computed = (Computed) parsed;
		assertEquals(label, computed.getLabel());
		assertEquals(Bool.class, computed.getExpression().getClass());
	}
	
}
