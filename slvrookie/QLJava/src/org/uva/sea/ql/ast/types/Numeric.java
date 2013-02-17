package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitors.interfaces.ITypeVisitor;

public class Numeric extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToNumeric();
	}

	@Override
	public boolean isCompatibleToIntType() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoneyType() {
		return true;
	}

	@Override
	public boolean isCompatibleToNumeric() {
		return true;
	}

	@Override
	public <T> T accept(ITypeVisitor<T> Typevisitor) {
		return null;
	}

}
