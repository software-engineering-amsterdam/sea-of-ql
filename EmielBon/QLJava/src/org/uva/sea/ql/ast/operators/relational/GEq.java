package org.uva.sea.ql.ast.operators.relational;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.operators.BinaryOperator;

public class GEq extends BinaryOperator {

	public GEq(Expr leftOperand, Expr rightOperand) {
		super(leftOperand, rightOperand);
	}
	
}
