package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitors.ITypeVisitor;

public class MoneyType extends Numeric {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToMoneyType();
	}

	@Override
	public boolean isCompatibleToMoneyType() {
		return true;
	}

	@Override
	public boolean isCompatibleToIntType() {
		return false;
	}

	@Override
	public <T> T accept(ITypeVisitor<T> Typevisitor) {
		return Typevisitor.visit(this);
	}

}
