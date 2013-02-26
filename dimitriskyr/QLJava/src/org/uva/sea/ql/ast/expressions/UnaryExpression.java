package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.*;

public abstract class UnaryExpression extends Expr {
	private Expr value;

	public UnaryExpression(Expr value) {
		this.value = value;
	}

	public Expr getValue() {
		return value;
	}

}