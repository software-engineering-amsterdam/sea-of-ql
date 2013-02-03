package org.uva.sea.ql.ast.operation.arithmetic;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.IntegerExpression;
import org.uva.sea.ql.ast.operation.BinaryOperation;

public class BinaryArithmeticOperation extends ArithmeticOperation implements
		BinaryOperation {
	
	protected IntegerExpression left_operand;
	protected IntegerExpression right_operand;
	
	BinaryArithmeticOperation(IntegerExpression left_operand, IntegerExpression right_operand) {
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
