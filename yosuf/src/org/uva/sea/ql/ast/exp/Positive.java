package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.visitor.NaturalVisitor;
import org.uva.sea.ql.visitor.ValuableVisitor;

public class Positive extends Unary<IntegerValue> {

	public Positive(final Expression<IntegerValue> operation) {
		super(operation);
	}

	@Override
	public <T> T accept(final NaturalVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public IntegerValue accept(final ValuableVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return Nature.NUMERIC;
	}
}
