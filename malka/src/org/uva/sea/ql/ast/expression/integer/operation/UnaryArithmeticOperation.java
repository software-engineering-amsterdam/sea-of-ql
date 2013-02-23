package org.uva.sea.ql.ast.expression.integer.operation;

import org.uva.sea.ql.ast.expression.integer.IntegerExpression;
import org.uva.sea.ql.ast.expression.operation.UnaryOperation;

public abstract class UnaryArithmeticOperation extends IntegerOperation implements
		UnaryOperation {

	protected IntegerExpression operand;
	
	UnaryArithmeticOperation(IntegerExpression operand) {
		this.operand = operand;
	}
	
	@Override
	public IntegerExpression getOperand() {
		return operand;
	}

}
