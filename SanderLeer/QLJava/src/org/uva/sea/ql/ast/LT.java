package org.uva.sea.ql.ast;

public class LT extends BinaryExpression {
	public LT(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
