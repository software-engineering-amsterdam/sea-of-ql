package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;

public class NEq extends BinaryOperationExpression {

	public NEq(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}
}
