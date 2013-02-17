package org.uva.sea.ql.ast.expression.bool.operation.logical;

import org.uva.sea.ql.ast.expression.bool.BooleanExpression;
import org.uva.sea.ql.ast.expression.bool.operation.BinaryBooleanOperation;

public class And extends BinaryBooleanOperation {

	public And(BooleanExpression left, BooleanExpression right) {
		super(left, right);
	}

}
