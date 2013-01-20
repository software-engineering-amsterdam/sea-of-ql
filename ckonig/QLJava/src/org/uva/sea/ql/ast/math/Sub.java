package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.Expr;

public class Sub extends BinaryMathOperator {
	public static final String str = "-";

	public Sub(Expr left, Expr right) {
		super(left, right);
	}
}
