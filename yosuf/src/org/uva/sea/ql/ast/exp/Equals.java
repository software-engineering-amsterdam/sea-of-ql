package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.Type;


public class Equals extends Binary {

	public Equals(final Expression left, final Expression right) {
		super(left, right);
	}

	@Override
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type getType() {
		return new Bools();
	}

}
