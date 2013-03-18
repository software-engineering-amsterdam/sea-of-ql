package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.TypeVisitor;

public class IntType extends NumericType {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToInt();
	}

	@Override
	public boolean isCompatibleToInt() {
		return true;
	}

	@Override
	public <T> T accept(TypeVisitor<T> typeVisitor) {
		return typeVisitor.visit(this);
	}
}
