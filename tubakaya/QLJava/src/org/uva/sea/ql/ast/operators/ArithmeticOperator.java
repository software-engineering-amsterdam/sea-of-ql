package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.types.IntegerType;
import org.uva.sea.ql.ast.types.Type;

public abstract class ArithmeticOperator extends BinaryOperator {

	public ArithmeticOperator(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public Type getType() {
		return new IntegerType();
	}
}
