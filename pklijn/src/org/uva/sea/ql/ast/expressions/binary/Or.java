package org.uva.sea.ql.ast.expressions.binary;


import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.ast.values.Value;

public class Or extends Binary {

	public Or(Expr left, Expr right) {
		super(left, right);
		allowedTypes.add(new BoolType());
	}

	@Override
	public Value eval(Env environment) {
		return new BoolValue(
				((BoolValue)getLeft().eval(environment)).getValue() ||
				((BoolValue)getRight().eval(environment)).getValue()
				);
	}

	@Override
	public Type typeOf(Env environment) {
		return new org.uva.sea.ql.ast.types.BoolType();
	}
}
