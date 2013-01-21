package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class Div extends BinaryOperator {

	public Div(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
