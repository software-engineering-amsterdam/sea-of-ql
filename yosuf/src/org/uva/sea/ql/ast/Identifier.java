package org.uva.sea.ql.ast;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.ast.exp.Expression;

public class Identifier extends Expression {

	private final String name;

	/**
	 * 
	 * @param name
	 *            (not null)
	 */
	public Identifier(final String name) {
		this.name = name;
		state.assertNotNull(this.name, "Identifier.name");
	}

	public String getName() {
		return name;
	}

}
