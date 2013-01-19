package org.uva.sea.ql.ast.operators.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class Add extends BinaryOperator {

	public Add(Expr leftOperand, Expr rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
