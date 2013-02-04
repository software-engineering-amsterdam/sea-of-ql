package org.uva.sea.ql.tests.ast.expr.IdentTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expr.Ident;

import static org.junit.Assert.assertEquals;

public class HashCodeTests {

	@Test
	public void getHashcodeCalled_delegatesToGetHashcodeOfName() {
		final String name = "abcdefghijklmnopqrstuvwxyz";
		Ident ident = new Ident(name);
		
		assertEquals(name.hashCode(), ident.hashCode());
	}
	
}
