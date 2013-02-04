package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Type;

public class Int extends Numeric {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}
	
}