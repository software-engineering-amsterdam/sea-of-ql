package org.uva.sea.ql.ast.exp;

public class Divide extends Binary {

	public Divide(final Expression left, final Expression right) {
		super(left, right);
	}

	@Override
	public Nature getNature() {
		return new Numeric();
	}

	@Override
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
