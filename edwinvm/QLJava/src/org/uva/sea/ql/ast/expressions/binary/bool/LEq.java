package org.uva.sea.ql.ast.expressions.binary.bool;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.expressions.binary.BinaryBoolExpr;

public class LEq extends BinaryBoolExpr {
	public LEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}