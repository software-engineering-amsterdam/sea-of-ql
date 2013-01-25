package org.uva.sea.ql.ast.operation.arithmetic;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operation.UnaryOperation;

public class UnaryArithmeticOperation extends ArithmeticOperation implements
		UnaryOperation {

	protected Expression operand;
	
	UnaryArithmeticOperation(Expression operand) {
		this.operand = operand;
	}
	
	@Override
	public Expression getOperand() {
		return operand;
	}

}
