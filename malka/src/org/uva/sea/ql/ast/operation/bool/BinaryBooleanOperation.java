package org.uva.sea.ql.ast.operation.bool;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operation.BinaryOperation;

public class BinaryBooleanOperation extends BooleanOperation implements
		BinaryOperation {
	
	protected Expression left_operand;
	protected Expression right_operand;
	
	public BinaryBooleanOperation(Expression left, Expression right) {
		left_operand = left;
		left_operand = right;
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
