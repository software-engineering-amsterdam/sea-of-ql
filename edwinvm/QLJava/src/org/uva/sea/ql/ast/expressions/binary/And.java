package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

public class And extends BinaryBoolExpr {
	public And(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}