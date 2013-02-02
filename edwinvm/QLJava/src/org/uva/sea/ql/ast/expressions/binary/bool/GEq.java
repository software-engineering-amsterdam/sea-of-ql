package org.uva.sea.ql.ast.expressions.binary.bool;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.expressions.binary.BinaryBoolExpr;

public class GEq extends BinaryBoolExpr {
	public GEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}