package ast.expression.value;

import ast.expression.ValueExpression;

public class Int extends ValueExpression {

	private final int value;

	public Int(int n) {
		this.value = n;
	}

	public int getValue() {
		return value;
	}

}
