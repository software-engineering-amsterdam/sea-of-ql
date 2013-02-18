package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.NaturalVisitor;

public class Substitute extends Binary<IntegerValue, IntegerValue> {

	public Substitute(final Expression<IntegerValue> left,
			final Expression<IntegerValue> right) {
		super(left, right);
	}

	@Override
	public <T> T accept(final NaturalVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public IntegerValue accept(final ExpressionVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return new Numeric();
	}

}
