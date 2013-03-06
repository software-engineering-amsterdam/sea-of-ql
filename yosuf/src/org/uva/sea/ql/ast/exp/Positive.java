package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.Type;


public class Positive extends Unary {

	public Positive(final Expression operation) {
		super(operation);
	}

	@Override
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type getType() {
		return new Numeric();
	}
}
