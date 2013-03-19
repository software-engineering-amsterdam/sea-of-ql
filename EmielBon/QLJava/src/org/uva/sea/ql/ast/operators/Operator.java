package org.uva.sea.ql.ast.operators;

import java.util.List;

import org.uva.sea.ql.ast.Expression;

/**
 * Represents an n-ary operator
 */
public abstract class Operator extends Expression {
	
	protected List<Expression> operands;
	
	protected Operator(List<Expression> operands) {
		this.operands = operands;
	}
	
	/**
	 * Returns all operands of this operator
	 * @return A list containing all operands of this operator
	 */
	public List<Expression> getOperands() {
		return operands;
	}
	
}
