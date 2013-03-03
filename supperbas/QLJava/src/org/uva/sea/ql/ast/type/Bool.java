package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.Type;

public class Bool extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBool();
	}

	@Override
	public boolean isCompatibleToBool() {
		return true;
	}

	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		return "Bool";
	}

}
