package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.Value;

public class LEq extends Binary{
	
	public LEq(Expr left, Expr right) {
		super(left,right);
	}

	@Override
	public Value interpret() {
		// TODO Auto-generated method stub
		return null;
	}

}
