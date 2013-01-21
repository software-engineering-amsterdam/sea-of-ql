package org.uva.sea.ql.ast.numeric;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.interfaces.INumeric;


public class Add extends NumericBaseOperator2 implements INumeric {

	public Add(Expr leftHandOperand, Expr rightHandOperand) {
		super(leftHandOperand, rightHandOperand);
	}
	
	
	public int getValue(){
		return getNumericLeftOperand().getValue() + getNumericRightOperand().getValue();
	}

}
