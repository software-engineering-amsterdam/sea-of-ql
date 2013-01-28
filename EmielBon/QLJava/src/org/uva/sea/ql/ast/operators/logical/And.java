package org.uva.sea.ql.ast.operators.logical;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class And extends BinaryOperator {

	public And(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
