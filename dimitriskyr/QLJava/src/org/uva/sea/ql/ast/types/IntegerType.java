package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.Type;

public class IntegerType extends NumericType {
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInteger();
	}
	
	public boolean isCompatibleToInteger() {
		return true;
	}
	
	
}
