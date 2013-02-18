package org.uva.sea.ql.ast.expressions.binaryExpr;

import org.uva.sea.ql.ast.expressions.Expr;

public abstract class BinaryExpr extends Expr {
	private final Expr lhs;
	private final Expr rhs;

	public BinaryExpr(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;		
	}
	
	public Expr getLhs() {
		return lhs;
	}
	
	public Expr getRhs() {
		return rhs;
	}
}