package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitors.TypeVisitor;

public class IntType extends NumericType{
	
	@Override 
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}
	
	public String toString() {
		return "integer";
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
