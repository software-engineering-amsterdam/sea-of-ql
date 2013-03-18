package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.TypeVisitor;

public class StrType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStr();
	}

	@Override
	public boolean isCompatibleToStr() {
		return true;
	}

	@Override
	public <T> T accept(TypeVisitor<T> typeVisitor) {
		return typeVisitor.visit(this);
	}
}
