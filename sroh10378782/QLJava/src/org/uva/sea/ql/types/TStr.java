package org.uva.sea.ql.types;

import org.uva.sea.ql.types.visitor.Visitor;

public class TStr extends Type {
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStr();
	}
	@Override
	public boolean isCompatibleToStr() { 
		return true; 
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
