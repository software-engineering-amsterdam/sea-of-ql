package org.uva.sea.ql.ast.exp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.uva.sea.ql.ast.type.MoneyType;
import org.uva.sea.ql.ast.type.StringType;

public class EqualsTest {

	@Test
	public void testIdentifier() {
		Identifier kabul = new Identifier("Kabul");
		Identifier mazar = new Identifier("Mazar");

		assertFalse(kabul.equals(mazar));

		assertTrue(kabul.equals(kabul));
		assertEquals(kabul, new Identifier("Kabul"));
	}

	@Test
	public void testBools() {
		assertTrue(new Bools().equals(new Bools()));

		assertFalse(new Bools().equals(new Numeric()));
		assertFalse(new Bools().equals(new MoneyType()));
		assertFalse(new Bools().equals(new StringType()));
	}
}
