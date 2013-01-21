package org.uva.sea.ql.ast;

public class And extends BinaryExpression {
	public And(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
