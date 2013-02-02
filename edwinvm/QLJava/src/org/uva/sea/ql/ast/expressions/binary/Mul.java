package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

public class Mul extends BinaryNumericExpr {
	public Mul(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}