package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitors.TypeVisitor;

public class StringType extends Type {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStr();
	}
	
	@Override
	public boolean isCompatibleToStr() {
		return true;
	}
	
	public String toString() {
		return "string";
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}


