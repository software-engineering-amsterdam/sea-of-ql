package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.IntegerValue;
import org.uva.sea.ql.visitor.NaturalVisitor;
import org.uva.sea.ql.visitor.ValuableVisitor;

public class Negative extends Unary<IntegerValue> {

	public Negative(final Expression<IntegerValue> operation) {
		super(operation);
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
