package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.nodes.values.Money;
import org.uva.sea.ql.ast.nodes.values.Value;

public class MoneyType extends NumericType{


	@Override
	  public boolean isCompatibleTo(Type t) {
	     return t.isCompatibleToMoney();
	}
	
	@Override
	public String toString() {
		return "MoneyType";
	}

	@Override
	public Value getDefaultValue() {
		return new Money(0);
	}
	
}
