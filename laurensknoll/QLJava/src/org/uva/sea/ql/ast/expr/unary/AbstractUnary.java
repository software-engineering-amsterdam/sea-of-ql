package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public abstract class AbstractUnary extends AbstractExpr {

	private final AbstractExpr expression;

	public AbstractUnary(AbstractExpr expression) {
		this.expression = expression;
	}

	public AbstractExpr getExpression() {
		return this.expression;
	}

}
