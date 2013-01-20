package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class LEq extends BinaryOperator {

	public LEq(Expr leftOperand, Expr rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
