package org.uva.sea.ql.ast;

public abstract class BinaryOptn extends Optn {
	private final Expr operand1;
	private final Expr operand2;
	
	protected BinaryOptn(Expr operand1, Expr operand2) {
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	public Expr getOperand1() {
		return operand1;
	}
	
	public Expr getOperand2() {
		return operand2;
	}
}
