package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class Eq extends BinaryOperator {

	public Eq(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
