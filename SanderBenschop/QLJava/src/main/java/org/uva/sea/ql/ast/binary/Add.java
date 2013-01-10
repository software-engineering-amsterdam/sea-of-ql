package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;

public class Add extends BinaryOperationExpression {

	public Add(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}
}
