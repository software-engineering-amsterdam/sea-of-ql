package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.math.BinaryMathOperator;

public class GEq extends BinaryMathOperator{
	public static final String str = ">=";

	public GEq(Expr left, Expr right) {
		super(left, right);
	}
}
