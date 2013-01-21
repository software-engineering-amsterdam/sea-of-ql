package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class GT extends BinaryOperator {

	public GT(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
