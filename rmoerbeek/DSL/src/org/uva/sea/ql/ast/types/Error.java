package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitors.TypeVisitor;

public class Error extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return false;
	}
	
	public String toString() {
		return "error";
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
