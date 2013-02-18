package org.uva.sea.ql.core.dom.operators;

import org.uva.sea.ql.core.dom.Expression;

public abstract class ArithmeticOperator extends Expression {
	
	private final Expression lhs;
	private final Expression rhs;

	public ArithmeticOperator(Expression lhs, Expression rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

}
