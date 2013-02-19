package org.uva.sea.ql.ast.type;

public class Str extends Type {

	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithStr();
	}

	public boolean isCompatibleWithStr() {
		return true;
	}
	
}