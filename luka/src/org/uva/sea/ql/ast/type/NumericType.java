package org.uva.sea.ql.ast.type;

public class NumericType extends Type{

	public boolean isCompatibleTo(Type t) {
	     return t.isCompatibleToNumeric();
	  }
	  public boolean isCompatibleToInt() {
	     return true;
	}
	  public boolean isCompatibleToMoney() {
	     return true;
	}
	  public boolean isCompatibleToNumeric() {
	     return true;
	}

	
}
