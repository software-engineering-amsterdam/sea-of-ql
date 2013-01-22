package org.uva.sea.ql.ast;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ast.values.Value;

public class Bool extends Expr {

	private final boolean value;

	public Bool(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}

	@Override
	public Value eval() {
		return new org.uva.sea.ql.ast.values.BoolValue(value);
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
