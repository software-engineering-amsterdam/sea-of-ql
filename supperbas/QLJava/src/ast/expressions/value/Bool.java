package ast.expressions.value;

import ast.expressions.ValueExpression;

public class Bool extends ValueExpression {

	private final String name;

	public Bool(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
