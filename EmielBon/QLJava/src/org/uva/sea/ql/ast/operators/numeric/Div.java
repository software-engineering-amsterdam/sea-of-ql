package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class Div extends BinaryOperator {

	public Div(Expr leftOperand, Expr rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
