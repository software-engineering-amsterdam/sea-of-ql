package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.math.BinaryMathOperator;

public class NEq extends BinaryMathOperator{
	public static final String str = "!=";

	public NEq(Expr left, Expr right) {
		super(left, right);
	}
}
