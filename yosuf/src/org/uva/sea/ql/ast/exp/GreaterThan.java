package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.visitor.NaturalVisitor;
import org.uva.sea.ql.visitor.ValuableVisitor;

public class GreaterThan extends Binary<BooleanValue, IntegerValue> {

	public GreaterThan(final Expression<IntegerValue> left,
			final Expression<IntegerValue> right) {
		super(left, right);
	}

	@Override
	public <T> T accept(final NaturalVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return Nature.BOOLEAN;
	}

	@Override
	public BooleanValue accept(final ValuableVisitor visitor) {
		return visitor.visit(this);
	}

}
