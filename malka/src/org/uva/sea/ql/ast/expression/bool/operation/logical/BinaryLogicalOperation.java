package org.uva.sea.ql.ast.expression.bool.operation.logical;

import org.uva.sea.ql.ast.expression.bool.BooleanExpression;
import org.uva.sea.ql.ast.expression.bool.operation.BinaryBooleanOperation;

public abstract class BinaryLogicalOperation extends BinaryBooleanOperation {

	protected BooleanExpression left;
	protected BooleanExpression right;
	
	public BinaryLogicalOperation(BooleanExpression left, BooleanExpression right) {
		super(left, right);
	}
	
}
