package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.visitor.Visitor;

public abstract class BinaryExpr extends Expr {
	protected final Expr lhs, rhs;

	protected BinaryExpr(Expr lhs, Expr rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expr getLhs() {
		return lhs;
	}

	public Expr getRhs() {
		return rhs;
	}
	
	@Override
	public abstract <T> T accept(Visitor<T> visitor);
	
	@Override
	public String toString() {
		return this.getClass().toString(); 
	}
	
	
}
