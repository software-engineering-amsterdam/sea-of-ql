package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Type;

public class NumericType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToNumeric();
	}

	@Override
	public boolean isCompatibleToInteger() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}

	@Override
	public boolean isCompatibleToNumeric() {
		return true;
	}

}
