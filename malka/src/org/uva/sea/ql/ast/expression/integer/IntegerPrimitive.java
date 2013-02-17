package org.uva.sea.ql.ast.expression.integer;


public class IntegerPrimitive implements IntegerExpression {
	private final int value;
	
	public IntegerPrimitive(int n) {
		this.value = n;
	}
	
	public int getValue() {
		return this.value;
	}
}
