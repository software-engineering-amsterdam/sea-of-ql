package org.uva.sea.ql.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.type.IntType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.interpreter.Value;

public class Int extends Expr {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	@Override
	public Value interpret() {
		return new org.uva.sea.ql.interpreter.IntVal(this.value);
	}
	
	@Override
	public Type typeOf(Map<Ident, Type> typeEnv) {
		return new IntType();
	}
	
	@Override
	public List<Error> checkType(Map<Ident, Type> typeEnv) {
		return new ArrayList<Error>();
	}
	
}
