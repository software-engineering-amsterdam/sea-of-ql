package org.uva.sea.ql.evaluator.value;

/**
 * Represents an undefined value.
 */
public class Undefined extends Value {
	/**
	 * Holds the undefined value.
	 */
	public final static Undefined UNDEFINED = new Undefined();

	/**
	 * Hidden constructor.
	 */
	private Undefined() {
	}

	@Override
	public Object getValue() {
		return null;
	}
}
