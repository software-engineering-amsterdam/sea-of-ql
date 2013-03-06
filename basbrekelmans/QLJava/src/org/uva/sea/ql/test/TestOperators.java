package org.uva.sea.ql.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.uva.sea.ql.runtime.values.BooleanValue;
import org.uva.sea.ql.runtime.values.IntegerValue;
import org.uva.sea.ql.runtime.values.MoneyValue;
import org.uva.sea.ql.runtime.values.Value;

public class TestOperators {

	@Test
	public void testBooleans() {
		final Value t = new BooleanValue(true);
		final Value f = new BooleanValue(false);
		assertEquals(true, t.or(f).getValue());
		assertEquals(false, t.and(f).getValue());
		assertEquals(true, t.xor(f).getValue());
		assertEquals(false, t.xor(t).getValue());
		assertEquals(false, t.equals(f).getValue());
		assertEquals(true, t.notEquals(f).getValue());
	}

	@Test
	public void testComparisons() {
		final Value one = new MoneyValue(1.0);
		final Value two = new IntegerValue(2);

		assertEquals(true, one.lessThan(two).getValue());
		assertEquals(true, one.lessThanOrEquals(two).getValue());
		assertEquals(false, one.greaterThan(two).getValue());
		assertEquals(false, one.greaterThanOrEquals(two).getValue());
		assertEquals(false, two.lessThan(two).getValue());
		assertEquals(false, two.greaterThan(two).getValue());
		assertEquals(true, two.greaterThanOrEquals(two).getValue());
		assertEquals(true, two.lessThanOrEquals(two).getValue());
	}

	@Test
	public void testNumerics() {
		final Value one = new MoneyValue(1.0);
		final Value two = new IntegerValue(2);
		final Value three = new MoneyValue(3.0);

		assertEquals(0.5, one.divide(two).getValue());
		assertEquals(1.0 / 3.0, one.divide(three).getValue());
		assertEquals(6.0, one.add(two).add(three).getValue());
		assertEquals(6.0, one.multiply(two).multiply(three).getValue());
	}

}
