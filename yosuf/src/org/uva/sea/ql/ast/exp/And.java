package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.BooleanValue;
import org.uva.sea.ql.visitor.NaturalVisitor;
import org.uva.sea.ql.visitor.ValuableVisitor;

public class And extends Binary<BooleanValue, BooleanValue> {

	public And(final Expression<BooleanValue> left,
			final Expression<BooleanValue> right) {
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
