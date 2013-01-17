package org.uva.sea.ql.ast.propositional;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Operator1;
import org.uva.sea.ql.interfaces.IBoolean;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.Stack;


public class Not extends Operator1 implements IBoolean{
	
	public Not(Expr operand){
		super(operand);
	}
	
	public boolean isSatisfied(){
		return !((IBoolean)operand).isSatisfied();
	}
	
	
	public void accept(IVisitor visitor, Stack stack) throws Exception {
		visitor.visit(this, stack);
	}
}
