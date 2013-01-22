package org.uva.sea.ql.ast.operation.bool.relational;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operation.bool.BinaryBooleanOperation;

public class GEq extends BinaryBooleanOperation {

	public GEq(Expression left, Expression right) {
		super(left, right);
	}

}
