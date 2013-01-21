package ast.expressions.value;

import ast.expressions.ValueExpression;

public class Str extends ValueExpression {

	private final String name;

	public Str(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
