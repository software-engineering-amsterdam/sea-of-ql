package org.uva.sea.ql.ast;

public class Not extends UnaryExpression {
	public Not(Expression operand) {
		super(operand);
	}

	@Override
	public void accept(ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
