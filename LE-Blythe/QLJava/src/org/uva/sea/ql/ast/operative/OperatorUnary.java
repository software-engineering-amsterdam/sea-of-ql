package org.uva.sea.ql.ast.operative;

import org.uva.sea.ql.ast.Expr;

public abstract class OperatorUnary extends Operator {

	protected final Expr operand;
	
	
	public OperatorUnary(Expr operand) {
		this.operand = operand;
	}
	
	
	public Expr getOperand() {
		return operand;
	}
}
