package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

public class LEq extends BinaryBoolExpr {
	public LEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}