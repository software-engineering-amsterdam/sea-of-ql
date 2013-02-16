package org.uva.sea.ql.ast.types;

public abstract class Type {

	public abstract boolean isCompatibleTo(Type t);
	public boolean isCompatibleToTypeBool() { return false;	}
	public boolean isCompatibleToTypeInt() { return false; }
	public boolean isCompatibleToTypeString() {	return false; }

}
