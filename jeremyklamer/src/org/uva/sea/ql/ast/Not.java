package org.uva.sea.ql.ast;

import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;

public class Not extends Expr {

	private final Expr expr;
	
	public Not(Expr expr) {
		this.expr = expr;
	}

	public Expr getExpr() {
		return expr;
	}
	
	@Override
	public Value interpret() {
		return new BoolVal(!((BoolVal)getExpr().interpret()).getBool());
	}

	@Override
	public Type typeOf(Env env) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
