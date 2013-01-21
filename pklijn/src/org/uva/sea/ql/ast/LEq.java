package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.BoolValue;
import org.uva.sea.ql.ast.values.IntValue;
import org.uva.sea.ql.ast.values.Value;

public class LEq extends Binary {

	public LEq(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public Value eval() {
		return new BoolValue(
				((IntValue)getLeft().eval()).getValue() <=
				((IntValue)getRight().eval()).getValue()
				);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.BoolType();
	}

}
