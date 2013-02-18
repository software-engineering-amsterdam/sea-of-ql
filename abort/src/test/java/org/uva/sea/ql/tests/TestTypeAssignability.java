package org.uva.sea.ql.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.types.datatypes.*;

// Test the check for ability to assign data types with a specific value
public class TestTypeAssignability extends TestBase {
	@Test
	public void testIntAssignability() {
		final IntType type = new IntType();
		assertTrue(type.isAssignableFrom("1000"));
		assertFalse(type.isAssignableFrom("1000.1"));
		assertFalse(type.isAssignableFrom("hello"));
		assertFalse(type.isAssignableFrom("false"));
	}

	@Test
	public void testStringAssignability() {
		final StringType type = new StringType();
		assertTrue(type.isAssignableFrom("1000"));
		assertTrue(type.isAssignableFrom("1000.1"));
		assertTrue(type.isAssignableFrom("hello"));
		assertTrue(type.isAssignableFrom("true"));
	}

	@Test
	public void testBoolAssignability() {
		final BoolType type = new BoolType();
		assertFalse(type.isAssignableFrom("1000"));
		assertFalse(type.isAssignableFrom("1000.1"));
		assertFalse(type.isAssignableFrom("hello"));
		assertTrue(type.isAssignableFrom("true"));
	}

	@Test
	public void testMoneyAssignability() {
		final MoneyType type = new MoneyType();
		assertTrue(type.isAssignableFrom("1000"));
		assertTrue(type.isAssignableFrom("1000.1"));
		assertFalse(type.isAssignableFrom("hello"));
		assertFalse(type.isAssignableFrom("true"));
		assertTrue(type.isAssignableFrom("150.123021391"));
	}

	@Test
	public void testNumericAssignability() {
		final NumericType type = new NumericType();
		assertFalse(type.isAssignableFrom("1000"));
		assertFalse(type.isAssignableFrom("1000.1"));
		assertFalse(type.isAssignableFrom("hello"));
		assertFalse(type.isAssignableFrom("true"));
	}
}
