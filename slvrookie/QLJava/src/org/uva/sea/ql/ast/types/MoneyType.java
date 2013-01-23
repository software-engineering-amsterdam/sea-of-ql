package org.uva.sea.ql.ast.types;

public class MoneyType extends Numeric {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToMoneyType();
	}

}
