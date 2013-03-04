package org.uva.sea.ql.types;

import org.uva.sea.ql.types.visitor.Visitor;

public class TBool extends Type{
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBool();
	}
	@Override
	public boolean isCompatibleToBool() {
		return true;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}