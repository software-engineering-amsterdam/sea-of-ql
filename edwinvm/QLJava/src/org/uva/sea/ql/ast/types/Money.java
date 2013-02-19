package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Type;

public class Money extends Numeric {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToMoney();
	}
	
}