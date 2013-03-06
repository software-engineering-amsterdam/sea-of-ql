package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitor.VisitorTypes;

public class TypeInt extends Type {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToTypeInt();
	}
	
	@Override
	public boolean isCompatibleToTypeInt() {
		return true;
	}

	@Override
	public <T> T accept(VisitorTypes<T> visitor) {
		return visitor.visit(this);
	}
	
}
