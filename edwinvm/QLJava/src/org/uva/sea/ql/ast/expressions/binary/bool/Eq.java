package org.uva.sea.ql.ast.expressions.binary.bool;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.expressions.binary.BinaryBoolExpr;

public class Eq extends BinaryBoolExpr {
	public Eq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}