package org.uva.sea.ql.ast.exp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TypeTest {

	@Test
	public void testEquals() {
		assertTrue(new Textual().equals(new Textual()));
		assertTrue(new Numeric().equals(new Numeric()));
		assertTrue(new Bools().equals(new Bools()));
	}

	@Test
	public void testNotEquals() {
		assertFalse(new Textual().equals(new Numeric()));
		assertFalse(new Textual().equals(new Bools()));
		assertFalse(new Bools().equals(new Numeric()));
		assertFalse(new Bools().equals(new Textual()));
	}

	@Test
	public void testIsValidInput() {
		assertTrue(new Bools().isValidInput("true"));
		assertTrue(new Bools().isValidInput("false"));
		assertTrue(new Numeric().isValidInput("0"));
		assertTrue(new Numeric().isValidInput("-10"));
		assertTrue(new Numeric().isValidInput("10"));
		assertTrue(new Textual().isValidInput("0"));
		assertTrue(new Textual().isValidInput("SomeName"));
		assertTrue(new Textual().isValidInput(""));
	}

	@Test
	public void testIsInvalidInput() {
		assertFalse(new Bools().isValidInput(""));
		assertFalse(new Bools().isValidInput("6"));
		assertFalse(new Numeric().isValidInput("a2"));
		assertFalse(new Numeric().isValidInput("-7a"));
		assertFalse(new Numeric().isValidInput("9a"));
		assertFalse(new Textual().isValidInput(null));
	}

}
