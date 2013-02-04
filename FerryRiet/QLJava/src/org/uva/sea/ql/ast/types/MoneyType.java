package org.uva.sea.ql.ast.types;

public class MoneyType extends TypeDescription {

	public MoneyType() {
		super("money");
	}

	@Override
	public boolean isCompatibleTo(TypeDescription t) {
		return t.isCompatibleToMoney();
	}

	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}
}
