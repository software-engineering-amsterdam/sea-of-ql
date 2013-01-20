package org.uva.sea.ql.ast.operators.logical;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class Or extends BinaryOperator {

	public Or(Expr leftOperand, Expr rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
