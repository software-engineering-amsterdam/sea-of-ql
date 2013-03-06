package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitor.VisitorTypes;

public class TypeString extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToTypeString();
	}
	
	@Override
	public boolean isCompatibleToTypeString() {
		return true;
	}

	@Override
	public <T> T accept(VisitorTypes<T> visitor) {
		return visitor.visit(this);
	}
	
}
