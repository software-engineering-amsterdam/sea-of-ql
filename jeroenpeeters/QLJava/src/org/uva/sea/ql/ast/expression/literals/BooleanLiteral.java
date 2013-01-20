package org.uva.sea.ql.ast.expression.literals;

import org.uva.sea.ql.ast.expression.Literal;

public class BooleanLiteral extends Literal {

	private final boolean value;

	public BooleanLiteral(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return value;
	}
	
}
