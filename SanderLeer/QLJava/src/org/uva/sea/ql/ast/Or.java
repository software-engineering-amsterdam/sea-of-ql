package org.uva.sea.ql.ast;

public class Or extends BinaryExpression {
	public Or(ASTNode lhs, ASTNode rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
