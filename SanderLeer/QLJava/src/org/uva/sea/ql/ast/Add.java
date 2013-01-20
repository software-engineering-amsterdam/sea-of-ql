package org.uva.sea.ql.ast;

public class Add extends BinaryExpression {
	public Add(ASTNode lhs, ASTNode rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
