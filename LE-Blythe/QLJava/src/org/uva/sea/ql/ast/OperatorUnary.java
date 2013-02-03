package org.uva.sea.ql.ast;

public abstract class OperatorUnary extends Operator {

	protected final Expr operand;
	
	
	public OperatorUnary(Expr operand) {
		this.operand = operand;
	}
	
	
	public Expr getOperand() {
		return operand;
	}
}
