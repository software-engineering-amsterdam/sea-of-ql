package org.uva.sea.ql.ast;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Expression;

public class Identifier extends Expression {

	private final String name;

	public Identifier(final String name) {
		state.assertNotNull(name, "Identifier.name");
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
