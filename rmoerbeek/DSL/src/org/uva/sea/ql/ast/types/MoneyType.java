package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitors.TypeVisitor;

public class MoneyType extends NumericType {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToMoney();
	}
	
	public String toString() {
		return "money";
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		// no visitor implementation yet 
		return null;
	}
	
}
