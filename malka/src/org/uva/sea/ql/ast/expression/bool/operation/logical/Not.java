package org.uva.sea.ql.ast.expression.bool.operation.logical;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.bool.BooleanExpression;
import org.uva.sea.ql.ast.expression.bool.operation.BooleanOperation;
import org.uva.sea.ql.ast.expression.operation.UnaryOperation;

public class Not extends BooleanOperation implements
UnaryOperation{

	protected BooleanExpression operand;
	
	public Not(BooleanExpression operand) {
		this.operand = operand;
	}
	
	@Override
	public Expression getOperand() {
		return operand;
	}

}
