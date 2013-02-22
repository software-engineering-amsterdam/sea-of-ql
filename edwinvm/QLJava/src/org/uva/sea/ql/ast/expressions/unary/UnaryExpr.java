package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.expressions.Expr;


public abstract class UnaryExpr extends Expr {
	private final Expr _expr;
	
	protected UnaryExpr(Expr expr) {
		_expr = expr;
	}
	
	public Expr getExpr() {
		return _expr;
	}
}