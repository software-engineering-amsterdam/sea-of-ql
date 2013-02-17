package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.expr.Unary;
import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.IntVal;
import org.uva.sea.ql.interpreter.Value;

public class Neg extends Unary {
	
	public Neg(Expr expr) {
		super(expr);
	}
	
	@Override
	public Value eval(Env env) {
		return new IntVal(((IntVal)expr.eval(null)).getValue() * -1);
	}
	
	@Override
	public Type typeOf(Env env) {
		return new IntType();
	}

}
