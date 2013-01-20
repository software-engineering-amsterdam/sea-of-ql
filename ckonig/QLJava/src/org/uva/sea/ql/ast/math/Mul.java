package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.Expr;

public class Mul extends BinaryMathOperator {
	public static final String str = "*";

	public Mul(Expr left, Expr right) {
		super(left, right);
	}
}
