package ast.expressions.value;

import ast.expressions.ValueExpression;

public class Ident extends ValueExpression {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
