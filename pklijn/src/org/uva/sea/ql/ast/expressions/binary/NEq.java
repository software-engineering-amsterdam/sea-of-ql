package org.uva.sea.ql.ast.expressions.binary;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.values.Value;

public class NEq extends Binary {

	public NEq(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public Value eval(Env environment) {
		return new org.uva.sea.ql.ast.values.BoolValue(!(getLeft().eval(environment).equals(getRight().eval(environment))));
	}

	@Override
	public Type typeOf(Env environment) {
		return new org.uva.sea.ql.ast.types.BoolType();
	}
	
	@Override
	public String toString() {
		return "(" + getLeft() + " != " + getRight() + ")";
	}

	@Override
	public Set<Type> allowedArgumentTypes() {
		return new HashSet<Type>(Arrays.asList(new Type[] {new IntType(), new StringType(), new BoolType()}));
	}
}
