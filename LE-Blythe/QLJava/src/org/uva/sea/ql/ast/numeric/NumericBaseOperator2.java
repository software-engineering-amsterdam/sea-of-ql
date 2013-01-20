package org.uva.sea.ql.ast.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Operator2;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.interfaces.INumeric;
import org.uva.sea.ql.util.Stack;

public abstract class NumericBaseOperator2 extends Operator2
		implements INumeric {
	
	public NumericBaseOperator2(Expr left, Expr right){
		super(left, right);
	}
	
	
	public INumeric getNumericLeftOperand(){
		return (INumeric)leftHandOperand;
	}
	
	
	public INumeric getNumericRightOperand(){
		return (INumeric)rightHandOperand;
	}
	
	
	public void accept(IVisitor visitor, Stack stack) throws Exception {
		visitor.visit(this, stack);
	}
}
