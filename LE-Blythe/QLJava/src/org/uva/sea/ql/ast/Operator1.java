package org.uva.sea.ql.ast;

public abstract class Operator1 extends Expr {

	protected final Expr operand;
	
	
	public Operator1(Expr operand) {
		this.operand = operand;
	}
	
	
	public Expr getOperand() {
		return operand;
	}
}
