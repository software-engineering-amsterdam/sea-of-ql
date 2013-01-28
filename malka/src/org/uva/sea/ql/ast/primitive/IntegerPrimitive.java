package org.uva.sea.ql.ast.primitive;

import org.uva.sea.ql.ast.IntegerExpression;

public class IntegerPrimitive extends IntegerExpression {
	private final int value;
	
	public IntegerPrimitive(int n) {
		this.value = n;
	}
	
	public int getValue() {
		return this.value;
	}
}
