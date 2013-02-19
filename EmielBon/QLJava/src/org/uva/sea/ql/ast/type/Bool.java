package org.uva.sea.ql.ast.type;

public class Bool extends Type {

	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithBool();
	}

	public boolean isCompatibleWithBool() {
		return true;
	}
	
}
