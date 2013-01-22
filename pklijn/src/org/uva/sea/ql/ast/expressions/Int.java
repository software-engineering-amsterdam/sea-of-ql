package org.uva.sea.ql.ast.expressions;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Value;

public class Int extends Expr {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	@Override
	public Value eval() {
		return new org.uva.sea.ql.ast.values.IntValue(value);
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
