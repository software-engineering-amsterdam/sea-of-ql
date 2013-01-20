package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class NEq extends BinaryOperator {

	public NEq(Expr leftOperand, Expr rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}