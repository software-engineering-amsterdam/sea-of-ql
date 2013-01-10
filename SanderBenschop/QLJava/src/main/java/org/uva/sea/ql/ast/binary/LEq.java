package org.uva.sea.ql.ast.binary;

import org.uva.sea.ql.ast.QLExpression;


public class LEq extends BinaryOperationExpression {

	public LEq(QLExpression leftHandSide, QLExpression rightHandSide) {
		super(leftHandSide, rightHandSide);
	}

}
