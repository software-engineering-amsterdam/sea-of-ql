package org.uva.sea.ql.ast;

public class Neg extends UnaryExpression {
	public Neg(Expression operand) {
		super(operand);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
