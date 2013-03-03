package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.NaturalVisitor;
import org.uva.sea.ql.ast.value.Value;

public class Multiply extends Binary {

	public Multiply(final Expression left, final Expression right) {
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
