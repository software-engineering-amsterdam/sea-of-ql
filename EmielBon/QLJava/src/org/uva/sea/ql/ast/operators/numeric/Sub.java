package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class Sub extends BinaryOperator {

	public Sub(Expr leftOperand, Expr rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
