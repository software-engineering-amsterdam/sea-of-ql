package org.uva.sea.ql.ast.operators.logical;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class Or extends BinaryOperator {

	public Or(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
