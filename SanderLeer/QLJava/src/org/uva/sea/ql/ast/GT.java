package org.uva.sea.ql.ast;

public class GT extends BinaryExpression {
	public GT(ASTNode lhs, ASTNode rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
