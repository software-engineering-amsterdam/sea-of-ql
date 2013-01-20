package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expr;

public class BinaryOperator extends Expr {

	protected final Expr leftOperand;
	protected final Expr rightOperand;
	
	public BinaryOperator(Expr leftOperand, Expr rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}
	
}
