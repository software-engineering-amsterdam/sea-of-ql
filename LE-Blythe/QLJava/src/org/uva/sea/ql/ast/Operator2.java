package org.uva.sea.ql.ast;

public abstract class Operator2 extends Expr {

	protected final Expr leftHandOperand, 
						rightHandOperand;
	
	
	public Operator2(Expr leftHandOperand, Expr rightHandOperand) {
		this.leftHandOperand = leftHandOperand;
		this.rightHandOperand = rightHandOperand;
	}
	
	
	public Expr getLeftHandOperand() {
		return leftHandOperand;
	}

	
	public Expr getRightHandOperand() {
		return rightHandOperand;
	}
}
