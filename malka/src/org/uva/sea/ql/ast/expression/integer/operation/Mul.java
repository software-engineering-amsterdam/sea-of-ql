package org.uva.sea.ql.ast.expression.integer.operation;

import org.uva.sea.ql.ast.expression.integer.IntegerExpression;

public class Mul extends BinaryArithmeticOperation {

	public Mul(IntegerExpression left, IntegerExpression right) {
		super(left, right);
	}

}
