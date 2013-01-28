package org.uva.sea.ql.ast.expression.unary;

import org.uva.sea.ql.ast.expression.Expression;

public abstract class UnaryExpression extends Expression {
	protected final Expression operand;
	
	public UnaryExpression(Expression operand) {
		this.operand = operand;
	}

	public Expression getOperand() {
		return operand;
	}
}
