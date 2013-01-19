package org.uva.sea.ql.ast;

public class Div extends BinaryExpression {
	public Div(ASTNode lhs, ASTNode rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
