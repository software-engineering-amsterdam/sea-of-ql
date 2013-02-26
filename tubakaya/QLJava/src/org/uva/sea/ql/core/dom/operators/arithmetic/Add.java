package org.uva.sea.ql.core.dom.operators.arithmetic;

import org.uva.sea.ql.core.dom.ExpressionVisitor;
import org.uva.sea.ql.core.dom.Expression;
import org.uva.sea.ql.core.dom.operators.ArithmeticOperator;

public class Add extends ArithmeticOperator {

	public Add(Expression lhs, Expression rhs) {
		super(lhs, rhs);
	}

	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}
}
