package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;

public class Eq extends Binary {

	public Eq(Expr left, Expr right) {
		super(left,right);
	}

	@Override
	public Value interpret(){
		IntVal li = (IntVal)(getLeft().interpret());
		IntVal ri = (IntVal)(getRight().interpret());
		return new BoolVal(li == ri);
	}

	@Override
	public Type typeOf(Env env) {
		// TODO Auto-generated method stub
		return null;
	}
}
