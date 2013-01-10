package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;

public class And extends BinaryOperationExpression {

	public And(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

}
