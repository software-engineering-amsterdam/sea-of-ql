package org.uva.sea.ql.ast.expr.binary;


import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.BoolVal;
import org.uva.sea.ql.interpreter.Env;
import org.uva.sea.ql.interpreter.Value;

public class And extends Binary {

	public And(Expr left, Expr right) {
		super(left,right);
	}

	@Override
	public Value eval(Env env) {
		BoolVal lb = (BoolVal) left.eval(env);
		BoolVal rb = (BoolVal) right.eval(env);
		return new BoolVal(lb.getValue() && rb.getValue());
	}

	@Override
	public Type typeOf(Env env) {
		return new BoolType();
	}
	
	@Override
	public Type getAllowedType() {
		return new BoolType();
	}
	
}
