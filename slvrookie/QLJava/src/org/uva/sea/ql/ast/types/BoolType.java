package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitors.interfaces.ITypeVisitor;

public class BoolType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToBoolType();
	}

	@Override
	public boolean isCompatibleToBoolType() {
		return true;
	}

	@Override
	public <T> T accept(ITypeVisitor<T> Typevisitor) {
		return Typevisitor.visit(this);
	}

}
