package org.uva.sea.ql.tests.ast.expr.IdentTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Ident;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EqualsTests {

	@Test
	public void everythingEquals_returnsTrue() {
		final String name = "abcdefghijklmnopqrstuvwxyz";
		
		Ident ident1 = new Ident(name);
		Ident ident2 = new Ident(name);
		
		assertTrue(ident1.equals(ident2));
	}
	
	@Test
	public void differentName_returnsFalse() {
		Ident ident1 = new Ident("abcde");
		Ident ident2 = new Ident("fghij");
		
		assertFalse(ident1.equals(ident2));
	}
	
}
