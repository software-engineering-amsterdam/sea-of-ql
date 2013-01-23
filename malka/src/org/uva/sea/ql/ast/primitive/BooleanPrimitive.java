package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.BooleanExpression;

public class BooleanPrimitive extends BooleanExpression {
	
	private final boolean value;
	
	public BooleanPrimitive(boolean bool) {
		this.value = bool;
	}

	public boolean getValue() {
		return this.value;
	}
	
}
