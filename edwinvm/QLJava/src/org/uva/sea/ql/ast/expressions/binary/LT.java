package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

public class LT extends BinaryBoolExpr {
	public LT(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}