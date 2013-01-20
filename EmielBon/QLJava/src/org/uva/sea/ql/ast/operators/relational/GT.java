package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class GT extends BinaryOperator {

	public GT(Expr leftOperand, Expr rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
