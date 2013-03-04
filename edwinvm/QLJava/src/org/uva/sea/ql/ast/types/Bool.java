package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitors.typevisitor.Visitor;


public class Bool extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBool();
	}

	@Override
	public boolean isCompatibleToBool() { return true; }

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "Bool";
	}
	
}