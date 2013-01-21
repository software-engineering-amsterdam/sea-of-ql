package ast.expression.value;

import ast.expression.ValueExpression;

public class Ident extends ValueExpression {

	private final String name;

	public Ident(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
