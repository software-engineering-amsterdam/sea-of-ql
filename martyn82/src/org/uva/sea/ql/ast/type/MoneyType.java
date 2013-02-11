package org.uva.sea.ql.ast.type;

public class MoneyType extends NumberType {
	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}

	@Override
	public String getName() {
		return "Money";
	}
}
