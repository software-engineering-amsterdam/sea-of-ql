package org.uva.sea.ql.ast;

public class LEq extends BinaryExpression {
	public LEq(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
