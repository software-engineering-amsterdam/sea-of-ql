package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

public class NEq extends BinaryBoolExpr {
	public NEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}