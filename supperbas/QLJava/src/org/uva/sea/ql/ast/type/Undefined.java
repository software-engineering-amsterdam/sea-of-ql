package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.Type;

public class Undefined extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}

	@Override
	public boolean isError() {
		return true;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return null;
	}
}
