package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Numeric;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;

public class Div extends Binary {

	public Div(Expr left, Expr right) {
		super(left,right);
	}

	@Override
	public Value interpret(){
		IntVal li = (IntVal)(getLeft().interpret());
		IntVal ri = (IntVal)(getRight().interpret());
		return new IntVal(li.getVal() / ri.getVal());	
	}

	@Override
	public Type typeOf(Env env) {
		return new Numeric();
	}

}
