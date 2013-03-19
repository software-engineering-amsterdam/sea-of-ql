package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitors.TypeVisitor;

public class BooleanType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBool();	
	}
	
	@Override
	public boolean isCompatibleToBool() {
		return true;
	}
	
	public String toString() {
		return "boolean";
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
