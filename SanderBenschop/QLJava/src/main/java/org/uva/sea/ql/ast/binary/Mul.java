package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;

public class Mul extends BinaryOperationExpression {

	public Mul(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}
}
