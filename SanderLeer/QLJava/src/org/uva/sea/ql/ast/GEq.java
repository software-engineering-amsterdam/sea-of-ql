package org.uva.sea.ql.ast;

public class GEq extends BinaryExpression {
	public GEq(ASTNode lhs, ASTNode rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
