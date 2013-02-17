package org.uva.sea.ql.ast.expression.integer.operation;

import org.uva.sea.ql.ast.expression.integer.IntegerExpression;

public class Div extends BinaryArithmeticOperation {

	public Div(IntegerExpression left, IntegerExpression right) {
		super(left, right);
	}

}
