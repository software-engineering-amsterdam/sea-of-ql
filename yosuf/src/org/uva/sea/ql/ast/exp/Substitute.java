package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.NumericValue;
import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.NaturalVisitor;

public class Substitute extends Binary<NumericValue, NumericValue> {

	public Substitute(final Expression<NumericValue> left,
			final Expression<NumericValue> right) {
		super(left, right);
	}

	@Override
	public <T> T accept(final NaturalVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public NumericValue accept(final ExpressionVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return new Numeric();
	}

}
