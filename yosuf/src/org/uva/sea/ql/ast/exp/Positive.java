package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.visitor.NaturalVisitor;
import org.uva.sea.ql.visitor.ValuableVisitor;

public class Positive extends Unary {

	public Positive(final Expression operation) {
		super(operation);
	}

	@Override
	public <T> T accept(final NaturalVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public <T> T accept(final ValuableVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Nature getNature() {
		return Nature.NUMERIC;
	}
}
