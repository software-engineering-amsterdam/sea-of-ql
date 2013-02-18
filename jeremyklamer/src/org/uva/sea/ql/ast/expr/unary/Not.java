package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Unary;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;

public class Not extends Unary {
	
	public Not(Expr expr) {
		super(expr);
	}
	
	@Override
	public Value eval(Env env) {
		//TODO make expr protected and remove getExpr. 
		return new BoolVal(!((BoolVal)expr.eval(env)).getValue());
	}

	@Override
	public Type typeOf(Env env) {
		return new BoolType();
	}
	
}
