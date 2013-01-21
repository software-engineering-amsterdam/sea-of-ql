package org.uva.sea.ql.ast.data;

import org.uva.sea.ql.ast.Expression;

public class Bool extends Expression {

	private final boolean value;

	public Bool(boolean b) {
		this.value = b;
	}

	public boolean getValue() {
		return value;
	}
	
}
