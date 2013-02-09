package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.visitor.NaturalVisitor;
import org.uva.sea.ql.visitor.ValuableVisitor;

public class NotEquals extends Binary {

	public NotEquals(final Expression left, final Expression right) {
		super(left, right);
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
		return Nature.BOOLEAN;
	}

}
