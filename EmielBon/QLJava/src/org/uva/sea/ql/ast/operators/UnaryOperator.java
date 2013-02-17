package org.uva.sea.ql.ast.operators;

import java.util.Arrays;
import org.uva.sea.ql.ast.Expression;

public abstract class UnaryOperator extends Operator {

	protected final Expression operand;
	
	protected UnaryOperator(Expression operand) {
		super(Arrays.asList(operand));
		this.operand = operand;
	}

	public Expression getOperand() {
		return operand;
	}
	
}
