package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.runtime.*;

public class TestOperators {

	@Test
	public void testBooleans() {
		Value t = new BooleanValue(true);
		Value f = new BooleanValue(false);
		assertEquals(true, t.or(f).getValue());
		assertEquals(false, t.and(f).getValue());
		assertEquals(true, t.xor(f).getValue());
		assertEquals(false, t.xor(t).getValue());
		assertEquals(false, t.equals(f).getValue());
		assertEquals(true, t.notEquals(f).getValue());
	}
	
	@Test
	public void testNumerics() {
		Value one = new MoneyValue(1.0);
		Value two = new IntegerValue(2);
		Value three = new MoneyValue(3.0);
		
		assertEquals(0.5, one.divide(two).getValue());
		assertEquals(1.0/3.0, one.divide(three).getValue());
		assertEquals(6.0, one.add(two).add(three).getValue());
		assertEquals(6.0, one.multiply(two).multiply(three).getValue());
	}

}
