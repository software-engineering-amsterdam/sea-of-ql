package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.expr.AbstractExpr;

public abstract class AbstractUnaryExpr extends AbstractExpr {

	private final AbstractExpr expr;

	public AbstractUnaryExpr(AbstractExpr expr) {
		this.expr = expr;
	}

	public AbstractExpr getExpression() {
		return this.expr;
	}

}
