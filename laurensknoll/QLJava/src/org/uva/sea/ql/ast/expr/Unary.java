package org.uva.sea.ql.ast.expr;

public abstract class Unary extends AbstractExpr {

	private final AbstractExpr expr;

	public Unary(AbstractExpr expr) {
		this.expr = expr;
	}

	public AbstractExpr getExpression() {
		return this.expr;
	}

}
