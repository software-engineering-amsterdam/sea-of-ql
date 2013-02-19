package org.uva.sea.ql.core.dom.operators;

import org.uva.sea.ql.core.dom.Expression;

public abstract class UnaryOperator  extends Expression {
	
	private final Expression expr;

	public UnaryOperator(Expression expr) {
		this.expr = expr;
	}

}
