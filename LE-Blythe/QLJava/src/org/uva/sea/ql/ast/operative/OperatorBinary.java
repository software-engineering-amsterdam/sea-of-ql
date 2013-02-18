package org.uva.sea.ql.ast.operative;

import org.uva.sea.ql.ast.Expr;

public abstract class OperatorBinary extends Operator {

	protected final Expr leftHandOperand, 
						rightHandOperand;
	
	
	public OperatorBinary(Expr leftHandOperand, Expr rightHandOperand) {
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
