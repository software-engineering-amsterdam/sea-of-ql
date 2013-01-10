package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;

public class LT extends BinaryOperationExpression {

	public LT(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

}
