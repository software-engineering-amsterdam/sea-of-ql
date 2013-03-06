package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.Type;

public class Int extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public boolean isCompatibleToInt(){
		return true;
	}

	public String toString() {
		return "Int";
	}
}
