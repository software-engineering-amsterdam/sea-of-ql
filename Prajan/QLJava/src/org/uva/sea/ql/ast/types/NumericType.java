package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.TypeVisitor;

public class NumericType extends Type {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToNumeric();
	}

	@Override
	public boolean isCompatibleToNumeric() {
		return true;
	}

	@Override
	public boolean isCompatibleToInt() {
		return false;
	}

	@Override
	public boolean isCompatibleToMoney() {
		return false;
	}

	@Override
	public <T> T accept(TypeVisitor<T> typeVisitor) {
		throw new UnsupportedOperationException("unsupported operation");
	}

}
