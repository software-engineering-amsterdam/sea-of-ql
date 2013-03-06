package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Type;

public class StringType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToString();
	}

	@Override
	public boolean isCompatibleToString() {
		return true;
	}

}
