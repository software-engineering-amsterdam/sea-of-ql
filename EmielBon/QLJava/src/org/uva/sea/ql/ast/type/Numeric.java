package org.uva.sea.ql.ast.type;

public class Numeric extends Type {

	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithNumeric();
	}

	public boolean isCompatibleWithInt() {
		return true;
	}
	
	public boolean isCompatibleWithNumeric() {
		return true;
	}
	
}
