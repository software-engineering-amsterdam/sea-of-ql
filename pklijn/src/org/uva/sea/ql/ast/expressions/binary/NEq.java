package org.uva.sea.ql.ast.expressions.binary;

import java.util.Map;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
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
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.BoolType();
	}
}
