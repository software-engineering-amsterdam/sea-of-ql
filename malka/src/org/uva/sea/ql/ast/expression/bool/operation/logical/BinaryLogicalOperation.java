package org.uva.sea.ql.ast.expression.bool.operation.logical;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.bool.BooleanExpression;
import org.uva.sea.ql.ast.expression.bool.operation.BinaryBooleanOperation;

public abstract class BinaryLogicalOperation extends BinaryBooleanOperation {
	
	protected BooleanExpression left_operand;
	protected BooleanExpression right_operand;
	
	public BinaryLogicalOperation(BooleanExpression left, BooleanExpression right) {
		left_operand = left;
		right_operand = right;
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
