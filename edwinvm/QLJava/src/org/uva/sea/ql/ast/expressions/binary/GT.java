package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

public class GT extends BinaryBoolExpr {
	public GT(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}