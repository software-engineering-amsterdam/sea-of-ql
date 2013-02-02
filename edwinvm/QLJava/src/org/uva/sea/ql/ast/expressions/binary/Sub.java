package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

public class Sub extends BinaryNumericExpr {
	public Sub(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}