package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitors.ITypeVisitor;

public class IntType extends Numeric {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToIntType();
	}

	@Override
	public boolean isCompatibleToIntType() {
		return true;
	}

	/*
	 * Ints are not compatible with money
	 * to ensure Type consistency in the QL
	 */
	
	@Override
	public boolean isCompatibleToMoneyType() {
		return false;
	}

	@Override
	public <T> T accept(ITypeVisitor<T> Typevisitor) {
		return Typevisitor.visit(this);
	}

}
