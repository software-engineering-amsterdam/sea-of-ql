package org.uva.sea.ql.ast.expression.integer.operation;

import org.uva.sea.ql.ast.expression.integer.IntegerExpression;

public class Add extends BinaryArithmeticOperation {

	public Add(IntegerExpression left, IntegerExpression right) {
		super(left, right);
	}

}
