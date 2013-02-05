package org.uva.sea.ql.ast.exp;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.visitor.ExpressionVisitor;

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

	@Override
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return Nature.TEXTUAL;
	}

	@Override
	public String toString() {
		return "Identifier [name=" + name + "]";
	}

}
