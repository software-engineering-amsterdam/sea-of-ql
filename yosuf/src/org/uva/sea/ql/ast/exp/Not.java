package org.uva.sea.ql.ast.exp;

import org.uva.sea.ql.ast.Type;


public class Not extends Unary {

	public Not(final Expression operation) {
		super(operation);
	}

	@Override
	public <T> T accept(final ExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Type getType() {
		return new Bools();
	}

}
