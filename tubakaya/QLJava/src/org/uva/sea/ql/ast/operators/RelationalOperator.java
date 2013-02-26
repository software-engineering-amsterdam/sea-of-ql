package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.types.BooleanType;
import org.uva.sea.ql.ast.types.Type;

public abstract class RelationalOperator extends BinaryOperator {

	public RelationalOperator(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type getType() {
		return new BooleanType();
	}
}
