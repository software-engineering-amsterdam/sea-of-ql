package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;

public class NEq extends Binary {

	public NEq(Expr left, Expr right) {
		super(left,right);
	}

	@Override
	public Value interpret(){
		IntVal li = (IntVal)(getLeft().interpret());
		IntVal ri = (IntVal)(getRight().interpret());
		return new BoolVal( li.getVal() != ri.getVal());
	}

	@Override
	public Type typeOf(Env env) {
		return new Numeric();
	}

}
