package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.value.Value;
import org.uva.sea.ql.visitor.ExpressionVisitor;
import org.uva.sea.ql.visitor.NaturalVisitor;

public class Divide extends Binary {

	public Divide(final Expression left, final Expression right) {
		super(left, right);
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
	public Value accept(final ExpressionVisitor visitor) {
		return visitor.visit(this);
	}

}
