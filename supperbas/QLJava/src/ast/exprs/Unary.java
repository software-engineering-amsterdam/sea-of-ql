package ast.exprs;

import ast.Expr;


public abstract class Unary extends Expr {
	
	private final Expr expr;

	public Unary(Expr expr) {
		this.expr = expr;
	}

	public Expr getExpr() {
		return expr;
	}

}
