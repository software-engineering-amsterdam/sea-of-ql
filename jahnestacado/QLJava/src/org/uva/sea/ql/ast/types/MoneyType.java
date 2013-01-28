package org.uva.sea.ql.ast.types;

public class MoneyType extends NumericType {

	@Override
	public boolean isCompatibleToType(Type type) {
		return type.isCompatibleToMoneyType();
	}

	@Override
	public boolean isCompatibleToMoneyType() {
		return true;
	}
	
	@Override
	public boolean isCompatibleToIntType() {
		return false;
	}

}
