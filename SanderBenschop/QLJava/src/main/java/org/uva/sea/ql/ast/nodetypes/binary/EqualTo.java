package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.QLExpression;

public class EqualTo extends BinaryOperationExpression {

	public EqualTo(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

}
