package org.uva.sea.ql.ast.propositional;

import org.uva.sea.ql.ast.*;


public class Or extends PropositionalBaseOperator2 {
	
	public Or(Expr leftHandOperand, Expr rightHandOperand){
		super(leftHandOperand, rightHandOperand);
	}

	
	public boolean isSatisfied(){
		return getBooleanLeftOperand().isSatisfied() || getBooleanRightOperand().isSatisfied();
	}
	
}
