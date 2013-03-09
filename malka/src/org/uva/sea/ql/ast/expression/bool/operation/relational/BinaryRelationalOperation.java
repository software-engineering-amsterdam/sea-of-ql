package org.uva.sea.ql.ast.expression.bool.operation.relational;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.bool.operation.BinaryBooleanOperation;

public abstract class BinaryRelationalOperation extends BinaryBooleanOperation {
	protected Expression left_operand;
	protected Expression right_operand;
	
	public BinaryRelationalOperation(Expression left, Expression right) {
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
	
	public void setLeftOperand(Expression left_operand) {
		this.left_operand = left_operand;
	}
}
