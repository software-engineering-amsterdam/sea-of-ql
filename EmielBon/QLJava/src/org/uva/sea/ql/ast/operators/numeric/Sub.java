package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class Sub extends BinaryOperator {

	public Sub(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
