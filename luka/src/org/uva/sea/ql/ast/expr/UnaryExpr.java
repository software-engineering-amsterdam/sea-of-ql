package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.visitor.Visitor;

public abstract class UnaryExpr extends Expr {
	
	protected final Expr expr;

	protected UnaryExpr(Expr expr) {
		this.expr = expr;
	}

	public Expr getExpr() {
		return this.expr;
	}

	@Override
	public abstract <T> T accept(Visitor<T> visitor);

	@Override
	public String toString() {
		return "abstract UnaryExpr";
	}
}
