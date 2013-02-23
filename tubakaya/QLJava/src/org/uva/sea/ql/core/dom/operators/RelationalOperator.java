package org.uva.sea.ql.core.dom.operators;

import org.uva.sea.ql.core.dom.Expression;

public abstract class RelationalOperator extends Expression {
	
	private final Expression lhs;
	private final Expression rhs;

	public RelationalOperator(Expression lhs, Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expression getLhs() {
		return lhs;
	}
	
	public Expression getRhs() {
		return rhs;
	}
}
