package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;

public abstract class BinaryOperationExpression extends QLExpression {
	
	private final QLExpression leftHandSide;
	private final QLExpression rightHandSide;
	
	public BinaryOperationExpression(QLExpression leftHandSide, QLExpression rightHandSide) {
		this.leftHandSide = leftHandSide;
		this.rightHandSide = rightHandSide;
	}

	public QLExpression getLeftHandSide() {
		return leftHandSide;
	}

	public QLExpression getRightHandSide() {
		return rightHandSide;
	}
}
