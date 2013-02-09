package org.uva.sea.ql.ast.expressions.unary;


import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.values.IntValue;
import org.uva.sea.ql.ast.values.Value;

public class Neg extends Unary {

	public Neg(Expr arg) {
		super(arg);
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

	@Override
	public Set<Type> allowedArgumentTypes() {
		return new HashSet<Type>(Arrays.asList(new Type[] {new IntType()}));
	}
}
