package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;

public class Or extends BinaryOperationExpression {

	public Or(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}
}
