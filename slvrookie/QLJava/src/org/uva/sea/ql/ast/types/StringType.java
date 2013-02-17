package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitors.ITypeVisitor;

public class StringType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToStringType();
	}

	@Override
	public boolean isCompatibleToStringType() {
		return true;
	}

	@Override
	public <T> T accept(ITypeVisitor<T> Typevisitor) {
		return Typevisitor.visit(this);
	}

}
