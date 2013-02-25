package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitor.VisitorTypes;

public abstract class Type {

	public abstract <T> T accept(VisitorTypes<T> visitor);
	public abstract boolean isCompatibleTo(Type t);
	public boolean isCompatibleToTypeBool() { return false;	}
	public boolean isCompatibleToTypeInt() { return false; }
	public boolean isCompatibleToTypeString() {	return false; }

}
