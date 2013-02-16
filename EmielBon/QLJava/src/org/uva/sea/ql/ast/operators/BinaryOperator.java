package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;

public abstract class BinaryOperator extends Expression {

	protected final Expression leftOperand;
	protected final Expression rightOperand;
	
	public BinaryOperator(Expression leftOperand, Expression rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}
	
}
