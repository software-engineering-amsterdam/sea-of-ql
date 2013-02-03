package org.uva.sea.ql.ast.value;

import static julius.validation.Assertions.state;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class StringValue extends Value {

	private final String value;

	/**
	 * 
	 * @param value
	 *            (not null)
	 */
	public StringValue(final String value) {
		super();
		this.value = value;
		state.assertNotNull(this.value, "StringLiteral.value");
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "StringLiteral [value=" + value + "]";
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
