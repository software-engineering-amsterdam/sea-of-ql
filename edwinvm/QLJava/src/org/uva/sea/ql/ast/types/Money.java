package org.uva.sea.ql.ast.types;


public class Money extends Numeric {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToMoney();
	}
	
	@Override
	public String toString() {
		return "Money";
	}
	
}