package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.QLExpression;

public class GreaterThanOrEqualTo extends BinaryOperationExpression {

	public GreaterThanOrEqualTo(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

}
