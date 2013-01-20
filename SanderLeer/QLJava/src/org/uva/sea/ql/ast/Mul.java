package org.uva.sea.ql.ast;

public class Mul extends BinaryExpression {
	public Mul(ASTNode lhs, ASTNode rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
