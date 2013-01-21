package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class Add extends BinaryOperator {

	public Add(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
