package org.uva.sea.ql.ast;

public class NEq extends BinaryExpression {
	public NEq(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
