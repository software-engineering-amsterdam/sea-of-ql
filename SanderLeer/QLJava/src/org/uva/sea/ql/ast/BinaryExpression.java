package org.uva.sea.ql.ast;

public abstract class BinaryExpression implements ASTNode {
	private final ASTNode lhs;
	private final ASTNode rhs;

	public BinaryExpression(ASTNode lhs, ASTNode rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}

	public ASTNode getLhs() {
		return lhs;
	}

	public ASTNode getRhs() {
		return rhs;
	}

}
