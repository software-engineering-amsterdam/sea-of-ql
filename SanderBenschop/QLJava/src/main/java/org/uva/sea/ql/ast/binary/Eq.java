package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;

public class Eq extends BinaryOperationExpression {

	public Eq(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

}
