package org.uva.sea.ql.ast.operation.arithmetic;

import org.uva.sea.ql.ast.IntegerExpression;

public class Div extends BinaryArithmeticOperation {

	public Div(IntegerExpression left, IntegerExpression right) {
		super(left, right);
	}

}
