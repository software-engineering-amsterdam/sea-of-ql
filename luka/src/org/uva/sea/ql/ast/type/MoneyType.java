package org.uva.sea.ql.ast.type;

public class MoneyType extends NumericType{


	@Override
	  public boolean isCompatibleTo(Type t) {
	     return t.isCompatibleToMoney();
	}
	
}
