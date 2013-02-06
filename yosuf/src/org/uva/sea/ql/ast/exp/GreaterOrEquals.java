package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class GreaterOrEquals extends Binary {

	public GreaterOrEquals(final Expression left, final Expression right) {
		super(left, right);
	}

	@Override
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return Nature.BOOLEAN;
	}

	@Override
	public String toString() {
		return "GreaterOrEquals [getNature()=" + getNature() + ", getLeft()="
				+ getLeft() + ", getRight()=" + getRight() + "]";
	}
}
