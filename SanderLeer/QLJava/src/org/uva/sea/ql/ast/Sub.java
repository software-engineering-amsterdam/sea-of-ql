package org.uva.sea.ql.ast;

public class Sub extends BinaryExpression {
	public Sub(ASTNode lhs, ASTNode rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
