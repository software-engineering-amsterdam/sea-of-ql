package org.uva.sea.ql.types;

import org.uva.sea.ql.types.visitor.Visitable;
import org.uva.sea.ql.types.visitor.Visitor;

public abstract class Type implements Visitable {
	public abstract boolean isCompatibleTo(Type t);
	public boolean isComputatedType(){ return false; }
	public boolean isCompatibleToInt() { return false; }
	public boolean isCompatibleToFloat() { return false; }
	public boolean isCompatibleToNumeric() { return false; }
	public boolean isCompatibleToStr() { return false; }
	public boolean isCompatibleToBool() { return false; }
	public boolean isCompatibleToMoney() { return false; }
	public abstract void accept(Visitor visitor);
}