package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class GEq extends BinaryOperator {

	public GEq(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
