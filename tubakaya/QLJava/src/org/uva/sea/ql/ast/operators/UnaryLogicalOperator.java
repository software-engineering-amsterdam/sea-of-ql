package org.uva.sea.ql.ast.operators;

import org.uva.sea.ql.ast.Expression;

public abstract class UnaryLogicalOperator extends UnaryOperator{

	public UnaryLogicalOperator(Expression expression) {
		super(expression);
	}

}
