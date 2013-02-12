package org.uva.sea.ql.ast.type;

public abstract class Type {

	public abstract boolean isCompatibleTo(Type t);
	
	  public boolean isCompatibleToInt() { return false; }
	  public boolean isCompatibleToNumeric() { return false; }
	  public boolean isCompatibleToStr() { return false; }
	  public boolean isCompatibleToBool() { return false; }
	  public boolean isCompatibleToMoney() { return false; }
}
