package org.uva.sea.ql.ast.expression.binary;

import org.uva.sea.ql.ast.expression.Expression;

public abstract class BinaryExpr extends Expression {

	protected final Expression lhs, rhs;
	
	public BinaryExpr(final Expression lhs, final Expression rhs){
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public Expression getLhs() {
		return lhs;
	}

	public Expression getRhs() {
		return rhs;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName()+" [lhs=" + lhs + ", rhs=" + rhs + "]";
	}
	
}