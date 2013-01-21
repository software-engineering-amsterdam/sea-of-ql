package ast.expression.value;

import ast.expression.ValueExpression;

public class Bool extends ValueExpression {
	private final String name;

	public Bool(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
