package org.uva.sea.ql.ast.exp;


public class GreaterOrEquals extends Binary {

	public GreaterOrEquals(final Expression left, final Expression right) {
		super(left, right);
	}

	@Override
	public Nature getNature() {
		return new Bools();
	}

	@Override
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
