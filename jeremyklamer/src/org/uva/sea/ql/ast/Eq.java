package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.BoolType;
import org.uva.sea.ql.interpreter.Int;
import org.uva.sea.ql.interpreter.Value;

public class Eq extends Binary {

	public Eq(Expr left, Expr right) {
		super(left,right);
	}

	@Override
	public Value interpret(){
		Int li = (Int)(getLeft().interpret());
		Int ri = (Int)(getRight().interpret());
		return new BoolType(li == ri);
	}

}
