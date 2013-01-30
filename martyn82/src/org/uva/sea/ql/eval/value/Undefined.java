package org.uva.sea.ql.eval.value;

/**
 * Represents an undefined value.
 */
public class Undefined extends Value {
	@Override
	public Object getValue() {
		return null;
	}
}
