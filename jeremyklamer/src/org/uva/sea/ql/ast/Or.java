package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.BoolType;
import org.uva.sea.ql.interpreter.Value;

public class Or extends Binary {

	public Or(Expr left, Expr right) {
		super(left,right);
	}

	@Override
	public Value interpret() {
		BoolType lb = (BoolType) getLeft().interpret();
		BoolType rb = (BoolType) getRight().interpret();
		return new BoolType(lb.getBool() || rb.getBool());
	}

}
