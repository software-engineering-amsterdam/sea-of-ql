package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class LT extends BinaryOperator {

	public LT(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
