package org.uva.sea.ql.ast;

public abstract class UnaryOptn extends Optn {
	
	private final Expr operand;
	
	protected UnaryOptn (Expr operand) {
		this.operand = operand;
	}
	
	public Expr getOperand() {
		return operand;
	}

}
