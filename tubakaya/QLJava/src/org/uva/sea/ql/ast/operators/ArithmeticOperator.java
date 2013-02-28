package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;

public abstract class ArithmeticOperator extends BinaryOperator {

	public ArithmeticOperator(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
}
