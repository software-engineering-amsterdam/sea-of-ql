package org.uva.sea.ql.ast.expressions.binary;


import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.types.*;
import org.uva.sea.ql.ast.values.Value;

public class NEq extends Binary {

	public NEq(Expr left, Expr right) {
		super(left, right);
		allowedTypes.add(new IntType());
		allowedTypes.add(new StringType());
		allowedTypes.add(new BoolType());
	}

	@Override
	public Value eval() {
		return new org.uva.sea.ql.ast.values.BoolValue(!(getLeft().eval().equals(getRight().eval())));
	}

	@Override
	public Type typeOf(Env environment) {
		return new org.uva.sea.ql.ast.types.BoolType();
	}
}