package org.uva.sea.ql.ast.types.datatypes;

public class IntType extends NumericType {
	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}
}
