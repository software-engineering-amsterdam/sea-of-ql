package org.uva.sea.ql.ast.expression.bool.operation.relational;

import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.bool.operation.BinaryBooleanOperation;

public class Eq extends BinaryBooleanOperation {

	public Eq(Expression left, Expression right) {
		super(left, right);
	}

}
