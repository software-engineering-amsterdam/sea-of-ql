package org.uva.sea.ql.ast.operation.arithmetic;

import org.uva.sea.ql.ast.IntegerExpression;

public class Mul extends BinaryArithmeticOperation {

	public Mul(IntegerExpression left, IntegerExpression right) {
		super(left, right);
	}

}
