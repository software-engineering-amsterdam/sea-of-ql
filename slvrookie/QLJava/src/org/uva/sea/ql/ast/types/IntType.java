package org.uva.sea.ql.ast.types;

public class IntType extends Numeric {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToIntType();
	}

}
