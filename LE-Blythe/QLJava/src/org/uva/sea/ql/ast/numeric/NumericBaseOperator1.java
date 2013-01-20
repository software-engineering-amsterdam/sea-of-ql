package org.uva.sea.ql.ast.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Operator1;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.interfaces.INumeric;
import org.uva.sea.ql.util.Stack;

public abstract class NumericBaseOperator1 extends Operator1
		implements INumeric {
	
	public NumericBaseOperator1(Expr operand){
		super(operand);
	}
	
	
	public INumeric getNumericOperand(){
		return (INumeric)operand;
	}
	
	
	public void accept(IVisitor visitor, Stack stack) throws Exception {
		visitor.visit(this, stack);
	}
}
