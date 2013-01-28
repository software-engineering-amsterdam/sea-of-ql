package org.uva.sea.ql.ast.expressions.binary;


import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.BoolType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.ast.values.Value;

public class And extends Binary {

	public And(Expr left, Expr right) {
		super(left, right);
		allowedTypes.add(new BoolType());
	}

	@Override
	public Value eval() {
		return new BoolValue(
				((BoolValue)getLeft().eval()).getValue() &&
				((BoolValue)getRight().eval()).getValue()
				);
	}

	@Override
	public Type typeOf(Env environment) {
		return new org.uva.sea.ql.ast.types.BoolType();
	}
}
