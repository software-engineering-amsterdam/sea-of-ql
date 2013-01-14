package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.QLExpression;

public class LessThanOrEqualTo extends BinaryOperationExpression {

	public LessThanOrEqualTo(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

}
