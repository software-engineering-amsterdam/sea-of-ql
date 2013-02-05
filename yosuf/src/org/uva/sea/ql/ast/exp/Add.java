package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.visitor.ExpressionVisitor;

public class Add extends Binary {

	public Add(final Expression left, final Expression right) {
		super(left, right);
	}

	@Override
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return Nature.NUMERIC;
	}
}