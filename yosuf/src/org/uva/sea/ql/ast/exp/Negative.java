package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.NumericValue;
import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.NaturalVisitor;

public class Negative extends Unary<NumericValue> {

	public Negative(final Expression<NumericValue> operation) {
		super(operation);
	}

	@Override
	public <T> T accept(final NaturalVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return new Numeric();
	}

	@Override
	public NumericValue accept(final ExpressionVisitor visitor) {
		return visitor.visit(this);
	}

}
