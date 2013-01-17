package org.uva.sea.ql.ast.comparative;

import org.uva.sea.ql.ast.Expr;

public class GEq extends ComparativeBaseOperator2{
	
	public GEq(Expr leftHandOperand, Expr rightHandOperand){
		super(leftHandOperand, rightHandOperand);
	}
	
	
	public boolean isSatisfied(){
		return getNumericLeftOperand().getValue() >= getNumericRightOperand().getValue();
	}
}
