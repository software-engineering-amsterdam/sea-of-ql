package org.uva.sea.ql.ast.value;

import org.uva.sea.ql.visitor.ASTNodeVisitor;
import org.uva.sea.ql.visitor.ExpressionVisitor;

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
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return Nature.BOOLEAN;
	}

	public boolean getValue() {
		return value;
	}
}
