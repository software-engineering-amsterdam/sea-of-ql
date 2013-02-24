package org.uva.sea.ql.ast.expressions;

public abstract class Unary extends Expr {
	
	private final Expr containedExpression;
	
	protected Unary(Expr containedExpression) {
		this.containedExpression = containedExpression;
	}
	
	public Expr getContainedExpression() {
		return containedExpression;
	}

}
