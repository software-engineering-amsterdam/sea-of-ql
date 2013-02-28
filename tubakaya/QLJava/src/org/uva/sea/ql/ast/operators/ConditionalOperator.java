package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;

public abstract class ConditionalOperator extends BinaryOperator {

	public ConditionalOperator(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
}
