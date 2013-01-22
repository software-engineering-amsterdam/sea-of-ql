package org.uva.sea.ql.ast.operation.bool.relational;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operation.bool.BinaryBooleanOperation;

public class Eq extends BinaryBooleanOperation {

	public Eq(Expression left, Expression right) {
		super(left, right);
	}

}
