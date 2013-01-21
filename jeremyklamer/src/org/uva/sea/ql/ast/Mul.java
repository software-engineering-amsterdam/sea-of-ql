package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.Int;
import org.uva.sea.ql.interpreter.Value;

public class Mul extends Binary {

	public Mul(Expr left, Expr right) {
		super(left,right);
	}

	public Value interpret(){
		Int li = (Int)(getLeft().interpret());
		Int ri = (Int)(getRight().interpret());
		return new Int(li.getVal() * ri.getVal());	
	}
	
}
