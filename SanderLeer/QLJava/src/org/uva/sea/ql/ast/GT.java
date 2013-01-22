package org.uva.sea.ql.ast;

public class GT extends BinaryExpression {
	public GT(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
