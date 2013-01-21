package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class Mul extends BinaryOperator {

	public Mul(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
