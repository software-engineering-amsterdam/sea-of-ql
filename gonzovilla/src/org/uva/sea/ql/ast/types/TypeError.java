package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitor.VisitorTypes;

public class TypeError extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	@Override
	public <T> T accept(VisitorTypes<T> visitor) {
		return visitor.visit(this);
	}

}
