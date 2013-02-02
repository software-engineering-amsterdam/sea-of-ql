package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Expr;

public abstract class Unary extends Expr {
	private final Expr _expr;
	
	protected Unary(Expr expr) {
		_expr = expr;
	}
	
	public Expr getExpr() {
		return _expr;
	}
}