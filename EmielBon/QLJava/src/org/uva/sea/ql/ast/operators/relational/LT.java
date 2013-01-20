package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class LT extends BinaryOperator {

	public LT(Expr leftOperand, Expr rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
