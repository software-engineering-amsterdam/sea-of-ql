package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.ast.visitors.typevisitor.Visitor;

public class Str extends Type {
	
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStr();
	}
	
	@Override
	public boolean isCompatibleToStr() { return true; }
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "Str";
	}
	
}