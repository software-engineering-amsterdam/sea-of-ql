package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expression;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class LEq extends BinaryOperator {

	public LEq(Expression leftOperand, Expression rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
