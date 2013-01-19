package org.uva.sea.ql.ast;

public abstract class UnaryExpression implements ASTNode {
	protected final ASTNode expr;
	
	public UnaryExpression(ASTNode expr) {
		this.expr = expr;
	}

	public ASTNode getExpr() {
		return expr;
	}
}
