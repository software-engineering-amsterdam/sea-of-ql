package org.uva.sea.ql.ast.type;

/**
 * Represents a money type.
 */
public class Money extends Number {
	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}

	@Override
	public String toString() {
		return "Money";
	}
}
