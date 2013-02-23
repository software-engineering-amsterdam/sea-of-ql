package org.uva.sea.ql.ast.expr.binary;


import org.uva.sea.ql.ast.expr.Binary;
import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.type.BoolType;
import org.uva.sea.ql.ast.type.IntType;
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
	public Value eval(Env env){
		IntVal li = (IntVal)(left.eval(env));
		IntVal ri = (IntVal)(right.eval(env));
		return new BoolVal(!(li.getValue().equals(ri.getValue())));
	}

	@Override
	public Type typeOf(Env env) {
		return new BoolType();
	}
	
	@Override
	public Type getAllowedType() {
		return new IntType();
	}

}