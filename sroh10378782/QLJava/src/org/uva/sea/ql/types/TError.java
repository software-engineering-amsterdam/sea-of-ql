package org.uva.sea.ql.types;

import org.uva.sea.ql.types.visitor.Visitor;

public class TError extends Type{
	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	@Override
	public void accept(Visitor visitor) {}
}
