package org.uva.sea.ql.types;

import org.uva.sea.ql.types.visitor.Visitor;

public class TNumeric extends Type{
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToNumeric();
	}
	@Override
	public boolean isCompatibleToInt() {
		return true;
	}
	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}
	@Override
	public boolean isCompatibleToNumeric() {
		return true;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
