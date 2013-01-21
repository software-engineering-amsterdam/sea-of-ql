package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.UnaryExpr;

public class UnaryMathOperator extends UnaryExpr implements MathOperator{

	public UnaryMathOperator(Expr ex) {
		super(ex);
	}

}
