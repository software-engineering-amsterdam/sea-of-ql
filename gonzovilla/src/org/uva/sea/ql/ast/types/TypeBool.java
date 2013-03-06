package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitor.VisitorTypes;

public class TypeBool extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToTypeBool();
	}
	
	@Override
	public boolean isCompatibleToTypeBool() {
		return true;
	}

	@Override
	public <T> T accept(VisitorTypes<T> visitor) {
		return visitor.visit(this);
	}

}