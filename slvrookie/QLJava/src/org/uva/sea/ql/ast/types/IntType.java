package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitors.interfaces.ITypeVisitor;

public class IntType extends Numeric {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToIntType();
	}

	@Override
	public boolean isCompatibleToIntType() {
		return true;
	}

	@Override
	public boolean isCompatibleToMoneyType() {
		return false;
	}

	@Override
	public <T> T accept(ITypeVisitor<T> Typevisitor) {
		return Typevisitor.visit(this);
	}

}
