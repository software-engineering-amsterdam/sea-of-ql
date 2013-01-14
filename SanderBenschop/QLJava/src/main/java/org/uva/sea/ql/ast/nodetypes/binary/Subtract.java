package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.QLExpression;

public class Subtract extends BinaryOperationExpression {

	public Subtract(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

}
