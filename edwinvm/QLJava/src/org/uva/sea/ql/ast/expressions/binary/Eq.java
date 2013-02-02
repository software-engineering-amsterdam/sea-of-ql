package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

public class Eq extends BinaryBoolExpr {
	public Eq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}