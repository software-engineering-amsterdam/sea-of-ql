package org.uva.sea.ql.type;


public abstract class Type {
	public abstract boolean isCompatibleTo(Type t);
	
	public boolean isCompatibleToIntegerType() { return false; }
	public boolean isCompatibleToNumericType() { return false; }
	public boolean isCompatibleToStringType() { return false; }
	public boolean isCompatibleToBooleanType() { return false; }
}
