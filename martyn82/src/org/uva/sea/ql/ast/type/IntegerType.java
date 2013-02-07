package org.uva.sea.ql.ast.type;

/**
 * Represents an Integer type.
 */
public class IntegerType extends NumberType {
	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public String toString() {
		return "Integer";
	}
}
