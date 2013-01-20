package org.uva.sea.ql.ast;

public class Eq extends BinaryExpression {
	public Eq(ASTNode lhs, ASTNode rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
