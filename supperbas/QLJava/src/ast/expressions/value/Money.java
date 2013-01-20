package ast.expressions.value;

import ast.expressions.ValueExpression;

public class Money extends ValueExpression {

	private final int value;

	public Money(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

}
