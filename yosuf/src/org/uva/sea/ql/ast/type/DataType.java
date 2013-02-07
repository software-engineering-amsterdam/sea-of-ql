package org.uva.sea.ql.ast.type;

import org.uva.sea.ql.ast.exp.Expression;

public abstract class DataType extends Expression {

	protected DataType() {
		super();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [Nature=" + getNature() + "]";
	}

}
