package ast.expression.value;

import ast.expression.ValueExpression;

public class Str extends ValueExpression {

	private final String name;

	public Str(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
