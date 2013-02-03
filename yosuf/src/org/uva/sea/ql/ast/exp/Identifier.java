package org.uva.sea.ql.ast.exp;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

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
	public void accept(final ASTNodeVisitor visitor) {
		visitor.visit(this);
	}
}
