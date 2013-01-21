package org.uva.sea.ql.ast;

import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Value;
import org.uva.sea.ql.ast.values.IntValue;


public class Add extends Binary {

	public Add(Expr left, Expr right) {
		super(left, right);
	}
	
	@Override
	public Value eval() {
		return new IntValue(
				((IntValue)getLeft().eval()).getValue() +
				((IntValue)getRight().eval()).getValue()
				);
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.IntType();
	}
}
