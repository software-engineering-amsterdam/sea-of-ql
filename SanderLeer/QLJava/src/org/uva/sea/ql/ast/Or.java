package org.uva.sea.ql.ast;

public class Or extends BinaryExpression {
	public Or(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
