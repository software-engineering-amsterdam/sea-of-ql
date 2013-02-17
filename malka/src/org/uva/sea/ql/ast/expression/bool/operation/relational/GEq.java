package org.uva.sea.ql.ast.expression.bool.operation.relational;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.bool.operation.BinaryBooleanOperation;

public class GEq extends BinaryBooleanOperation {

	public GEq(Expression left, Expression right) {
		super(left, right);
	}

}
