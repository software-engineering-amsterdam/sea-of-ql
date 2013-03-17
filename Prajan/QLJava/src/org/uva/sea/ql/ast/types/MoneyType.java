package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.TypeVisitor;

public class MoneyType extends NumericType {

	@Override
	public boolean isCompatibleTo(Type t) {
		return t.isCompatibleToMoney();
	}

	@Override
	public boolean isCompatibleToMoney() {
		return true;
	}

	@Override
	public <T> T accept(TypeVisitor<T> typeVisitor) {
		return typeVisitor.visit(this);
	}

}
