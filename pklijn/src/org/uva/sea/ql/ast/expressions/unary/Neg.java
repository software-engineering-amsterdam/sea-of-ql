package org.uva.sea.ql.ast.expressions.unary;


import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.values.IntValue;
import org.uva.sea.ql.ast.values.Value;

public class Neg extends Unary {

	public Neg(Expr arg) {
		super(arg);
		allowedTypes.add(new IntType());
	}

	@Override
	public Value eval(Env environment) {
		return new IntValue(((IntValue)getArg().eval(environment)).getValue() * -1);
	}

	@Override
	public Type typeOf(Env environment) {
		return new org.uva.sea.ql.ast.types.IntType();
	}
	
	@Override
	public String toString() {
		return "-" + getArg();
	}
}
