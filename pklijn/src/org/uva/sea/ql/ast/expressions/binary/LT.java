package org.uva.sea.ql.ast.expressions.binary;


import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.IntType;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.ast.values.IntValue;
import org.uva.sea.ql.ast.values.Value;

public class LT extends Binary {

	public LT(Expr left, Expr right) {
		super(left, right);
		allowedTypes.add(new IntType());
	}

	@Override
	public Value eval() {
		return new BoolValue(
				((IntValue)getLeft().eval()).getValue() <
				((IntValue)getRight().eval()).getValue()
				);
	}

	@Override
	public Type typeOf(Env environment) {
		return new org.uva.sea.ql.ast.types.BoolType();
	}
}
