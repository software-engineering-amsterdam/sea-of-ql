package org.uva.sea.ql.ast.operators;

import java.util.Arrays;
import org.uva.sea.ql.ast.Expression;

public abstract class BinaryOperator extends Operator {

	protected final Expression leftOperand;
	protected final Expression rightOperand;
	
	protected BinaryOperator(Expression leftOperand, Expression rightOperand) {
		super(Arrays.asList(leftOperand, rightOperand));
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	public Expression getLeftOperand() {
		return leftOperand;
	}

	public Expression getRightOperand() {
		return rightOperand;
	}
	
}
