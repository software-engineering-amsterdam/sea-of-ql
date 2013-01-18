package org.uva.sea.ql.ast.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.interfaces.INumeric;

public class Neg extends NumericBaseOperator1 implements INumeric{
	
	public Neg(Expr operand){
		super(operand);
	}
	
	
	public int getValue(){
		return -getNumericOperand().getValue();
	}
	
}
