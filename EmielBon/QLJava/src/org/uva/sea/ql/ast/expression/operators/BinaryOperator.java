package org.uva.sea.ql.ast.expression.operators;

import java.util.Arrays;
import org.uva.sea.ql.ast.expression.Expression;

/**
 * Represents a binary operator, i.e. an operator with two operands (left and right)
 */
public abstract class BinaryOperator extends Operator {

	protected final Expression leftOperand;
	protected final Expression rightOperand;
	
	protected BinaryOperator(Expression leftOperand, Expression rightOperand) {
		super(Arrays.asList(leftOperand, rightOperand));
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	/**
	 * Returns the left operand of this operator
	 * @return The left operand
	 */
	public Expression getLeftOperand() {
		return leftOperand;
	}

	/**
	 * Returns the right operand of this operator
	 * @return The right operand
	 */
	public Expression getRightOperand() {
		return rightOperand;
	}
	
}
