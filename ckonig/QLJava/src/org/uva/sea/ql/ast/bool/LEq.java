package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.math.BinaryMathOperator;

public class LEq extends BinaryMathOperator {
	public static final String str = "<=";

	public LEq(Expr left, Expr right) {
		super(left, right);
	}
}
