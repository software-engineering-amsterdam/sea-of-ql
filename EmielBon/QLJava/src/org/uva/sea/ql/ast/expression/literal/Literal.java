package org.uva.sea.ql.ast.expression.literal;

import org.uva.sea.ql.ast.expression.Expression;

public abstract class Literal<T> extends Expression {

	private final T value;
	
	public Literal(T n) {
		this.value = n;
	}

	public T getValue() {
		return value;
	}
	
	@Override
	public String getRepresentation() {
		return value.toString();
	}
	
}
