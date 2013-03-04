package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.Type;

public class Str extends Type {
	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStr();
	}

	@Override
	public boolean isCompatibleToStr() {
		return true;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		return "Str";
	}
}
