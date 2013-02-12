package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.visitor.NaturalVisitor;
import org.uva.sea.ql.visitor.ValuableVisitor;

public class Divide extends Binary<IntegerValue, IntegerValue> {

	public Divide(final Expression<IntegerValue> left,
			final Expression<IntegerValue> right) {
		super(left, right);
	}

	@Override
	public <T> T accept(final NaturalVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return Nature.NUMERIC;
	}

	@Override
	public IntegerValue accept(final ValuableVisitor visitor) {
		return visitor.visit(this);
	}

}
