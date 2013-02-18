package org.uva.sea.ql.ast.expression.bool.operation;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.bool.BooleanExpression;
import org.uva.sea.ql.ast.expression.operation.UnaryOperation;

public abstract class UnaryBooleanOperation extends BooleanOperation implements
		UnaryOperation {

	protected BooleanExpression operand;
	
	public UnaryBooleanOperation(BooleanExpression operand) {
		this.operand = operand;
	}
	
	@Override
	public Expression getOperand() {
		return operand;
	}


}
