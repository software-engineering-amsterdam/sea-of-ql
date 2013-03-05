package org.uva.sea.ql.ast.types;

public class MoneyType extends NumericType{
	
	@Override
	public boolean isCompatibleTo(Type t){
		return t.isCompatibleToMoney();
	}

}
