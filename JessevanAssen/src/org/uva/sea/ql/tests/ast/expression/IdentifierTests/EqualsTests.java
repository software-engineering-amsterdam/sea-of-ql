package org.uva.sea.ql.tests.ast.expression.IdentifierTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Identifier;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EqualsTests {

	@Test
	public void everythingEquals_returnsTrue() {
		final String name = "abcdefghijklmnopqrstuvwxyz";
		
		Identifier identifier1 = new Identifier(name);
		Identifier identifier2 = new Identifier(name);
		
		assertTrue(identifier1.equals(identifier2));
	}
	
	@Test
	public void differentName_returnsFalse() {
		Identifier identifier1 = new Identifier("abcde");
		Identifier identifier2 = new Identifier("fghij");
		
		assertFalse(identifier1.equals(identifier2));
	}
	
}
