package org.uva.sea.ql.tests.ast.expression.IdentifierTests;

import org.junit.Test;
import org.uva.sea.ql.ast.expression.Identifier;

import static org.junit.Assert.assertEquals;

public class HashCodeTests {

	@Test
	public void getHashcodeCalled_delegatesToGetHashcodeOfName() {
		final String name = "abcdefghijklmnopqrstuvwxyz";
		Identifier identifier = new Identifier(name);
		
		assertEquals(name.hashCode(), identifier.hashCode());
	}
	
}
