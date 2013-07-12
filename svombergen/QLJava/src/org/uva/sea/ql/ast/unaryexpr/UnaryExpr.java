package org.uva.sea.ql.ast.unaryexpr;

import org.uva.sea.ql.ast.Expr;

public abstract class UnaryExpr extends Expr {
	protected Expr expression;
	
	public UnaryExpr(Expr result) {
		expression = result;
	}
	
	public Expr getExpr() {
		return expression;
	}
	
	@Override
	public String toString() {
		return this.typeOf().toString() + expression;
	}
	
}
