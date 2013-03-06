package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Type;

public class BooleanType extends Type {
	boolean value;

	public boolean getValue() {
		return value;
	}

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBoolean();
	}

	@Override
	public boolean isCompatibleToBoolean() {
		return true;
	}

}
