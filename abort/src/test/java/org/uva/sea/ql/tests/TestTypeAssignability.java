package org.uva.sea.ql.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.uva.sea.ql.ast.types.datatypes.BoolType;
import org.uva.sea.ql.ast.types.datatypes.IntType;
import org.uva.sea.ql.ast.types.datatypes.MoneyType;
import org.uva.sea.ql.ast.types.datatypes.NumericType;
import org.uva.sea.ql.ast.types.datatypes.StringType;

// Test the check for ability to assign data types with a specific value
public class TestTypeAssignability extends TestBase {
	@Test
	public void testIntAssignability() {
		IntType type = new IntType();
		assertTrue(type.isAssignableFrom("1000"));
		assertFalse(type.isAssignableFrom("1000.1"));
		assertFalse(type.isAssignableFrom("hello"));
		assertFalse(type.isAssignableFrom("false"));
	}
	
	@Test
	public void testStringAssignability() {
		StringType type = new StringType();
		assertTrue(type.isAssignableFrom("1000"));
		assertTrue(type.isAssignableFrom("1000.1"));
		assertTrue(type.isAssignableFrom("hello"));
		assertTrue(type.isAssignableFrom("true"));
	}

	@Test
	public void testBoolAssignability() {
		BoolType type = new BoolType();
		assertFalse(type.isAssignableFrom("1000"));
		assertFalse(type.isAssignableFrom("1000.1"));
		assertFalse(type.isAssignableFrom("hello"));
		assertTrue(type.isAssignableFrom("true"));
	}
	
	@Test
	public void testMoneyAssignability() {
		MoneyType type = new MoneyType();
		assertTrue(type.isAssignableFrom("1000"));
		assertTrue(type.isAssignableFrom("1000.1"));
		assertFalse(type.isAssignableFrom("hello"));
		assertFalse(type.isAssignableFrom("true"));
		assertTrue(type.isAssignableFrom("150.123021391"));
	}
	
	@Test
	public void testNumericAssignability() {
		NumericType type = new NumericType();
		assertFalse(type.isAssignableFrom("1000"));
		assertFalse(type.isAssignableFrom("1000.1"));
		assertFalse(type.isAssignableFrom("hello"));
		assertFalse(type.isAssignableFrom("true"));
	}
}
