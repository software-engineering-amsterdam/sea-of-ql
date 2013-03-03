package org.uva.sea.ql.ast.types;


public class Int extends Numeric {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}
	
	@Override
	public String toString() {
		return "Int";
	}
	
}