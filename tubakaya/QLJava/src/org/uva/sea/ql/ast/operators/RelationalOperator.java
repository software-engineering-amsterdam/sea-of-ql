package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;

public abstract class RelationalOperator extends BinaryOperator {

	public RelationalOperator(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}
}
