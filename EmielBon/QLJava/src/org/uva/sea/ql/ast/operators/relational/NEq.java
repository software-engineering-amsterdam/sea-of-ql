package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class NEq extends BinaryOperator {

	public NEq(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}