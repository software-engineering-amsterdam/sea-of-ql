package org.uva.sea.ql.ast;

public abstract class UnaryExpression extends Expression {
	protected final Expression operand;
	
	public UnaryExpression(Expression operand) {
		this.operand = operand;
	}

	public Expression getOperand() {
		return operand;
	}
}
