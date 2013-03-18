package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.TypeVisitor;

public class BoolType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBool();
	}

	@Override
	public boolean isCompatibleToBool() {
		return true;
	}

	@Override
	public <T> T accept(TypeVisitor<T> typeVisitor) {
		return typeVisitor.visit(this);
	}

}
