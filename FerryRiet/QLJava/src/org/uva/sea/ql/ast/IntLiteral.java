package org.uva.sea.ql.ast;

import java.util.HashMap;

public class IntLiteral extends Expr {

	private final int value;

	public IntLiteral(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

	@Override
	public TypeDescription typeOf(HashMap<String, Statement> typeEnv) {
		return new NumeralType();
	}
}
