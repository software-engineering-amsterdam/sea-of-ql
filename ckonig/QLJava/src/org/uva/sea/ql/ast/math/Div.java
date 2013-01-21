package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.Expr;

public class Div extends BinaryMathOperator {
	public static final String str = "/";

	public Div(Expr left, Expr right) {
		super(left, right);
	}
}
