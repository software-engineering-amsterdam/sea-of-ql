package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Type;

public class Error extends Type {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}
	
}