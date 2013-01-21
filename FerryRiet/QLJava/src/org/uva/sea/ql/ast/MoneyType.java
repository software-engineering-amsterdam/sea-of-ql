package org.uva.sea.ql.ast;

public class MoneyType extends TypeDescription {

	public MoneyType() {
		super("money");
	}

	@Override
	public boolean compatibleType(TypeDescription testType) {
		return false;
	}
}
