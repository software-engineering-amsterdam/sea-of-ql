package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

public class GEq extends BinaryBoolExpr {
	public GEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}