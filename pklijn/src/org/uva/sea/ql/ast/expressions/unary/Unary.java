package org.uva.sea.ql.ast.expressions.unary;

import org.uva.sea.ql.ast.expressions.Expr;

public abstract class Unary extends Expr {
	private Expr arg;
	
	public Unary(Expr arg) {
		this.arg = arg;
	}
	
	public Expr getArg() {
		return arg;
	}
}
