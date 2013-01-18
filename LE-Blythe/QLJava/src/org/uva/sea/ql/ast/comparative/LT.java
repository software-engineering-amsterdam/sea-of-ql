package org.uva.sea.ql.ast.comparative;

import org.uva.sea.ql.ast.Expr;

public class LT extends ComparativeBaseOperator2{
	
	public LT(Expr leftHandOperand, Expr rightHandOperand){
		super(leftHandOperand, rightHandOperand);
	}
	
	
	public boolean isSatisfied(){
		return getNumericLeftOperand().getValue() < getNumericRightOperand().getValue();
	}
	
}
