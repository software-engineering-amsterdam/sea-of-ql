package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.Expr;

public class Neg extends UnaryMathOperator {
	public static final String str = "-";

	public Neg(Expr ex) {
		super(ex);
	}
}
