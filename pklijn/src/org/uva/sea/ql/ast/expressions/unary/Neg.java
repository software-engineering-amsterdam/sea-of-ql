package org.uva.sea.ql.ast.expressions.unary;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.Ident;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.IntValue;
import org.uva.sea.ql.ast.values.Value;

public class Neg extends Unary {

	public Neg(Expr arg) {
		super(arg);
	}

	@Override
	public Value eval() {
		return new IntValue(((IntValue)getArg().eval()).getValue() * -1);
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.IntType();
	}

	@Override
	public List<String> checkType(List<String> errors) {
		// TODO Auto-generated method stub
		return null;
	}

}
