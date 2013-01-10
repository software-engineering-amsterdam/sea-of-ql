package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;

public class GEq extends BinaryOperationExpression {

	public GEq(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

}
