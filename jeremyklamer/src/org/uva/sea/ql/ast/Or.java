package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;

public class Or extends Binary {

	public Or(Expr left, Expr right) {
		super(left,right);
	}

	@Override
	public Value interpret() {
		BoolVal lb = (BoolVal) getLeft().interpret();
		BoolVal rb = (BoolVal) getRight().interpret();
		return new BoolVal(lb.getBool() || rb.getBool());
	}

	@Override
	public Type typeOf(Env env) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
