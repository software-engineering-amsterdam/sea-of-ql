package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Type;

public class Bool extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBool();
	}

	@Override
	public boolean isCompatibleToBool() { return true; }
	
}