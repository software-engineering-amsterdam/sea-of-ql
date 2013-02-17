package org.uva.sea.ql.ast.expression.integer.operation;

import org.uva.sea.ql.ast.expression.integer.IntegerExpression;

public class Neg extends UnaryArithmeticOperation {

	public Neg(IntegerExpression operand) {
		super(operand);
	}

}
