package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Type;

public class BooleanType extends Type{

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBoolean();
	}
	
	@Override
	public boolean isCompatibleToBoolean() {
		return true;
	}
	
}
