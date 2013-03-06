package org.uva.sea.ql.ast.expression.integer.operation;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.integer.IntegerExpression;
import org.uva.sea.ql.ast.expression.operation.BinaryOperation;

public abstract class BinaryIntegerOperation extends IntegerOperation implements
		BinaryOperation {
	
	protected IntegerExpression left_operand;
	protected IntegerExpression right_operand;
	
	BinaryIntegerOperation(IntegerExpression left_operand, IntegerExpression right_operand) {
		this.left_operand = left_operand;
		this.right_operand = right_operand;
	}
	
	@Override
	public Expression getLeftOperand() {
		return left_operand;
	}

	@Override
	public Expression getRightOperand() {
		return right_operand;
	}

}
