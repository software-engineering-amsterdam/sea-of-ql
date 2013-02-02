package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

public class Or extends BinaryBoolExpr {
	public Or(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}