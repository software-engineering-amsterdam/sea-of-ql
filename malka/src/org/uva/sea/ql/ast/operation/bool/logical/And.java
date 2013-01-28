package org.uva.sea.ql.ast.operation.bool.logical;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operation.bool.BinaryBooleanOperation;

public class And extends BinaryBooleanOperation {

	public And(Expression left, Expression right) {
		super(left, right);
	}

}
