package org.uva.sea.ql.ast.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.interfaces.INumeric;

public class Pos extends NumericBaseOperator1 implements INumeric{
	
	public Pos(Expr operand){
		super(operand);
	}
	
	
	public int getValue(){
		return Math.abs(getNumericOperand().getValue());
	}
}
