package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.Type;

public class Divide extends Binary {

	public Divide(final Expression left, final Expression right) {
		super(left, right);
	}

	@Override
	public Type getType() {
		return new Numeric();
	}

	@Override
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
