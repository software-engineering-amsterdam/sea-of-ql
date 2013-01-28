package org.uva.sea.ql.ast.operation.bool.logical;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operation.bool.BinaryBooleanOperation;

public class Or extends BinaryBooleanOperation {

	public Or(Expression left, Expression right) {
		super(left, right);
	}

}
