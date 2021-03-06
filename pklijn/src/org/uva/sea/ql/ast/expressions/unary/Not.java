package org.uva.sea.ql.ast.expressions.unary;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.ast.values.Value;

public class Not extends Unary {

	public Not(Expr arg) {
		super(arg);
	}

	@Override
	public Value eval(Env environment) {
		return new BoolValue(!((BoolValue)getArg().eval(environment)).getValue());
	}

	@Override
	public Type typeOf(Env environment) {
		return new org.uva.sea.ql.ast.types.BoolType();
	}
	
	@Override
	public String toString() {
		return "!" + getArg();
	}

	@Override
	public Set<Type> allowedArgumentTypes() {
		return new HashSet<Type>(Arrays.asList(new Type[] {new BoolType()}));
	}
}
