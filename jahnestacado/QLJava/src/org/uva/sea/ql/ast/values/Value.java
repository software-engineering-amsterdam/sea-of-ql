package org.uva.sea.ql.ast.values;

import org.uva.sea.ql.ast.expr.Expr;

public abstract class Value<T> extends Expr {
	private final T value;

	protected Value(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

}
