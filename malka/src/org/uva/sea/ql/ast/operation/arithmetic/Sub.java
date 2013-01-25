package org.uva.sea.ql.ast.operation.arithmetic;

import org.uva.sea.ql.ast.IntegerExpression;

public class Sub extends BinaryArithmeticOperation {

	public Sub(IntegerExpression left, IntegerExpression right) {
		super(left, right);
	}

}
