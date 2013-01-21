package ast.expression.value;

import ast.expression.ValueExpression;

public class Money extends ValueExpression {

	private final int value;

	public Money(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

}
