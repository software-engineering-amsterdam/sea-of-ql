package org.uva.sea.ql.ast.type;


public abstract class Type {
	public abstract boolean isCompatibleTo(Type t);
	
	// subclasses will overwrite these functions when needed.
	public boolean isCompatibleToIntegerType() { return false; }
	public boolean isCompatibleToNumericType() { return false; }
	public boolean isCompatibleToStringType() { return false; }
	public boolean isCompatibleToBooleanType() { return false; }
}
