package org.uva.sea.ql.ast.operators;

import java.util.Arrays;

import org.uva.sea.ql.ast.Expression;

/**
 * Represents an unary operator, i.e. an operator with only one operand
 */
public abstract class UnaryOperator extends Operator {

	protected final Expression operand;
	
	protected UnaryOperator(Expression operand) {
		super(Arrays.asList(operand));
		this.operand = operand;
	}

	/**
	 * Returns the operand of this operator
	 * @return The operand of this operator
	 */
	public Expression getOperand() {
		return operand;
	}
	
	public String toString() {
		return getRepresentation() + operand;
	}
}
