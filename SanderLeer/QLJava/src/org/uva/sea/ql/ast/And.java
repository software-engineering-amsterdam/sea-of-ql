package org.uva.sea.ql.ast;

public class And extends BinaryExpression {
	public And(ASTNode lhs, ASTNode rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
