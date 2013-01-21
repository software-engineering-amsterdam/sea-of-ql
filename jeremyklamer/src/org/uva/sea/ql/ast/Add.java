package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.Int;
import org.uva.sea.ql.interpreter.Value;

public class Add extends Binary{

	public Add(Expr left, Expr right) {
		super(left,right);
	}
	
	@Override
	public Value interpret(){
		Int li = (Int)(getLeft().interpret());
		Int ri = (Int)(getRight().interpret());
		return new Int(li.getVal() + ri.getVal());	
	}
	
}
