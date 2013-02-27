package org.uva.sea.ql.type;

import org.uva.sea.ql.value.Value;

public abstract class Type {
	public abstract boolean isCompatibleTo(Type t);
	public abstract boolean isCompatibleTo(Value v);
	
	public boolean isCompatibleToIntegerType() { return false; }
	public boolean isCompatibleToNumericType() { return false; }
	public boolean isCompatibleToStringType() { return false; }
	public boolean isCompatibleToBooleanType() { return false; }
}