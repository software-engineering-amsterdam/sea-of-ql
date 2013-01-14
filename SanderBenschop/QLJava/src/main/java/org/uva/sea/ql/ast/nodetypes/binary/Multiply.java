package org.uva.sea.ql.ast.nodetypes.binary;

import org.uva.sea.ql.ast.QLExpression;

public class Multiply extends BinaryOperationExpression {

	public Multiply(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}
}
