package org.uva.sea.ql.ast.propositional;

import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.interfaces.IBoolean;
import org.uva.sea.ql.interfaces.IVisitor;
import org.uva.sea.ql.util.*;

public abstract class PropositionalBaseOperator2 extends Operator2
		implements IBoolean {
	
	public PropositionalBaseOperator2(Expr left, Expr right){
		super(left, right);
	}
	
	
	public IBoolean getBooleanLeftOperand(){
		return (IBoolean)leftHandOperand;
	}
	
	
	public IBoolean getBooleanRightOperand(){
		return (IBoolean)rightHandOperand;
	}

	
	public void accept(IVisitor visitor, Stack stack) throws Exception {
		visitor.visit(this, stack);
	}
}
