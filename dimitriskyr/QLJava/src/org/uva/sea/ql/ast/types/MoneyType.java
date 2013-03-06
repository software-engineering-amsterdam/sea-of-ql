package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Type;

public class MoneyType extends NumericType {
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToMoney();
	}

	public boolean isCompatibleToMoney() {
		return true;
	}
}
