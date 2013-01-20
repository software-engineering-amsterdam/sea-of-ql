package org.uva.sea.ql.ast.numeric;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.interfaces.INumeric;

public class Mul extends NumericBaseOperator2 implements INumeric {

	public Mul(Expr leftHandOperand, Expr rightHandOperand) {
		super(leftHandOperand, rightHandOperand);
	}
	
	
	public int getValue(){
		return getNumericLeftOperand().getValue() * getNumericRightOperand().getValue();
	}
	
}
