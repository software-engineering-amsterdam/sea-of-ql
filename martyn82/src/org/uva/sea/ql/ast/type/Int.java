package org.uva.sea.ql.ast.type;

/**
 * Represents an Integer type.
 */
public class Int extends Number {
	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public String toString() {
		return "Integer";
	}
}
