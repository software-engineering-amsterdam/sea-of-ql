package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class Eq extends BinaryOperator {

	public Eq(Expr leftOperand, Expr rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
