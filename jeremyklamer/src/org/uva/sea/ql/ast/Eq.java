package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.BoolType;
import org.uva.sea.ql.interpreter.Value;

public class Eq extends Binary {

	public Eq(Expr left, Expr right) {
		super(left,right);
	}

	@Override
	public Value interpret() {
		// TODO How to see if int or bool? 
		return new BoolType(getLeft().interpret() == getRight().interpret());
	}

}
