package org.uva.sea.ql.ast.types.datatypes;


public class MoneyType extends NumericType {	
	@Override
	public boolean isCompatibleToInt() {
		return true;
	}
	
	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}
}
