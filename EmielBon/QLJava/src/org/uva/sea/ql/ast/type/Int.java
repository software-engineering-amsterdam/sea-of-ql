package org.uva.sea.ql.ast.type;

public class Int extends Numeric {

	public boolean isCompatibleWith(Type t) {
		return t.isCompatibleWithInt();
	}
	
}
