package org.uva.sea.ql.ast.value;

import org.uva.sea.ql.visitor.ASTNodeVisitor;

public class BooleanValue extends Value {

	private final boolean value;

	public BooleanValue(final boolean value) {
		this.value = value;
	}

	@Override
	public void accept(final ASTNodeVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Value evaluate() {
		return this;
	}

	public boolean getValue() {
		return value;
	}
}
