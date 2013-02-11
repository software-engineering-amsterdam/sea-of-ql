package org.uva.sea.ql.ast.expressions.binary;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.ast.values.Value;

public class And extends Binary {

	public And(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public Value eval(Env environment) {
		return new BoolValue(
				((BoolValue)getLeft().eval(environment)).getValue() &&
				((BoolValue)getRight().eval(environment)).getValue()
				);
	}

	@Override
	public Type typeOf(Env environment) {
		return new org.uva.sea.ql.ast.types.BoolType();
	}
	
	@Override
	public String toString() {
		return "(" + getLeft() + " && " + getRight() + ")";
	}

	@Override
	public Set<Type> allowedArgumentTypes() {
		return new HashSet<Type>(Arrays.asList(new Type[] {new BoolType()}));
	}
}
