package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Type;

public abstract class ConditionalOperator extends BinaryOperator {

	public ConditionalOperator(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type getType() {
		return new BooleanType();
	}
}
