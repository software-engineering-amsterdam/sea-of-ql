package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public abstract class AbstractUnary extends AbstractExpr {

	private final AbstractExpr expr;

	public AbstractUnary(AbstractExpr expr) {
		this.expr = expr;
	}

	public AbstractExpr getExpression() {
		return this.expr;
	}

}
