package org.uva.sea.ql.ast.value;

import org.uva.sea.ql.ast.exp.Expression;

public abstract class Value extends Expression {

	protected Value() {
		super();
	}

	/**
	 * 
	 * @return a string representation of this value
	 */
	public abstract String getAsString();

}
