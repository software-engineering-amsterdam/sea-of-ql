package org.uva.sea.ql.ast.types;

public class NumericType extends Type {

	@Override
	public boolean isCompatibleToType(Type type) {
		return type.isCompatibleToNumericType();
	}

	@Override
	public boolean isCompatibleToNumericType() {
		return true;
	}

	@Override
	public boolean isCompatibleToIntType() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoneyType() {
		return true;
	}

}
