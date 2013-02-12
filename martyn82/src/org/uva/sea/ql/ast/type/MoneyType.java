package org.uva.sea.ql.ast.type;

public class MoneyType extends NumberType {
	public final static MoneyType MONEY = new MoneyType();

	private MoneyType() {}

	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}

	@Override
	public String getName() {
		return "Money";
	}
}
