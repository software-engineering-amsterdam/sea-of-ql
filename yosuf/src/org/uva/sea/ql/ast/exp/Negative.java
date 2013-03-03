package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.NaturalVisitor;
import org.uva.sea.ql.ast.value.Value;

public class Negative extends Unary {

	public Negative(final Expression operation) {
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
	public Value accept(final ExpressionVisitor visitor) {
		return visitor.visit(this);
	}

}
