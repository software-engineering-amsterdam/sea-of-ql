package org.uva.sea.ql.ast.types;

import org.uva.sea.ql.visitor.IParametrizedTypeVisitor;
import org.uva.sea.ql.visitor.ITypeVisitor;

public final class MoneyType extends Type {
	MoneyType() {
	}

	@Override
	public <TParameter, TResult> TResult accept(
			final IParametrizedTypeVisitor<TParameter, TResult> visitor,
			final TParameter arg) {
		return visitor.visit(this, arg);
	}

	@Override
	public <T> T accept(final ITypeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean isNumber() {
		return true;
	}

	@Override
	public String toString() {
		return "money";
	}
}
