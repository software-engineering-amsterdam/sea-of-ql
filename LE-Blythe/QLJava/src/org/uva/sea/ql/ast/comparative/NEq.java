package org.uva.sea.ql.ast.comparative;

import org.uva.sea.ql.ast.Expr;

public class NEq extends ComparativeBaseOperator2{
	
	public NEq(Expr leftHandOperand, Expr rightHandOperand){
		super(leftHandOperand, rightHandOperand);
	}
	
	
	public boolean isSatisfied(){
		return getNumericLeftOperand().getValue() != getNumericRightOperand().getValue();
	}
	

}
