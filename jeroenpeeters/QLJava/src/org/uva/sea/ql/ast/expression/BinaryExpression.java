package org.uva.sea.ql.ast.expression;


public abstract class BinaryExpression extends Expression {

	protected final Expression lhs, rhs;
	
	public BinaryExpression(final Expression lhs, final Expression rhs){
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