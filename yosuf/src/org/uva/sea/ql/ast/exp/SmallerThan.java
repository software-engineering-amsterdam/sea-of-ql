package org.uva.sea.ql.ast.exp;


public class SmallerThan extends Binary {

	public SmallerThan(final Expression left, final Expression right) {
		super(left, right);
	}

	@Override
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return new Bools();
	}

}
