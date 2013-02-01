package org.uva.sea.ql.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.uva.sea.ql.ast.traversal.base.HandSide;

// Test handside instance
public class TestHandSide extends TestBase {
	@Test
	public void testHandSide() {
		assertEquals("left", HandSide.LEFT.toString());
		assertEquals("right", HandSide.RIGHT.toString());
		assertEquals("both", HandSide.BOTH.toString());
		assertFalse(HandSide.LEFT.equals(HandSide.RIGHT));
		assertFalse(HandSide.RIGHT.equals(HandSide.LEFT));
		assertFalse(HandSide.BOTH.equals(HandSide.LEFT));
		assertFalse(HandSide.BOTH.equals(HandSide.RIGHT));
	}
}
