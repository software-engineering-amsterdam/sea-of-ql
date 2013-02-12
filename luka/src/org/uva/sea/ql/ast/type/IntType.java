package org.uva.sea.ql.ast.type;

public class IntType extends NumericType {

	// Double dispatch
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}

}
