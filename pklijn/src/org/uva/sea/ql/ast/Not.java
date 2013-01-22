package org.uva.sea.ql.ast;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Value;

public class Not extends Unary {

	public Not(Expr arg) {
		super(arg);
	}

	@Override
	public Value eval() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new org.uva.sea.ql.ast.types.BoolType();
	}
	
	@Override
	public List<String> checkType(List<String> errors) {
		return errors;
	}

}
