package org.uva.sea.ql.ast.value;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class IntegerValue extends Value {

	private final int value;

	/**
	 * 
	 * @param value
	 *            (not null)
	 */
	public IntegerValue(final int value) {
		super();
		this.value = value;
		state.assertNotNull(this.value, "Integer.value");
	}

	public int getValue() {
		return value;
	}

	@Override
	public void accept(final ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Value evaluate() {
		return this;
	}
}
