package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.Value;

public class Or extends Binary {

	public Or(Expr left, Expr right) {
		super(left,right);
	}

	@Override
	public Value interpret() {
		// TODO Auto-generated method stub
		return null;
	}

}
