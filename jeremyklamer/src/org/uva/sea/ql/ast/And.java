package org.uva.sea.ql.ast;

import org.uva.sea.ql.interpreter.BoolType;
import org.uva.sea.ql.interpreter.Value;

public class And extends Binary {

	public And(Expr left, Expr right) {
		super(left,right);
	}

	@Override
	public Value interpret() {
		BoolType li = (BoolType) getLeft().interpret();
		BoolType ri = (BoolType) getRight().interpret();
		return new BoolType(li.getBool() && ri.getBool());
	}

}
