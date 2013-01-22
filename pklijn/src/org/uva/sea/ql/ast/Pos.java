package org.uva.sea.ql.ast;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.IntValue;
import org.uva.sea.ql.ast.values.Value;

public class Pos extends Unary {

	public Pos(Expr arg) {
		super(arg);
	}

	@Override
	public Value eval() {
		return new IntValue(Math.abs(((IntValue)getArg().eval()).getValue()));
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.IntType();
	}
	
	@Override
	public List<String> checkType(List<String> errors) {
		return errors;
	}

}
