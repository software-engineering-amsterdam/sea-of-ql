package org.uva.sea.ql.ast.operation.arithmetic;

import org.uva.sea.ql.ast.IntegerExpression;

public class Add extends BinaryArithmeticOperation {

	public Add(IntegerExpression left, IntegerExpression right) {
		super(left, right);
	}

}
