package org.uva.sea.ql.ast.operation.bool.logical;

import org.uva.sea.ql.ast.BooleanExpression;
import org.uva.sea.ql.ast.operation.bool.BinaryBooleanOperation;

public class BinaryLogicalOperation extends BinaryBooleanOperation {

	protected BooleanExpression left;
	protected BooleanExpression right;
	
	public BinaryLogicalOperation(BooleanExpression left, BooleanExpression right) {
		super(left, right);
	}
	
}
