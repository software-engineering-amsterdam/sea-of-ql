package org.uva.sea.ql.ast.operation.bool.logical;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operation.UnaryOperation;
import org.uva.sea.ql.ast.operation.bool.BooleanOperation;

public class Not extends BooleanOperation implements
UnaryOperation{

	protected Expression operand;
	
	public Not(Expression operand) {
		this.operand = operand;
	}
	
	@Override
	public Expression getOperand() {
		return operand;
	}

}
