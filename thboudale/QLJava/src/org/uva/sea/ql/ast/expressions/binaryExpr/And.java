package org.uva.sea.ql.ast.expressions.binaryExpr;

import org.uva.sea.ql.ast.expressions.Expr;

public class And extends BinaryExpr {

	public And(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}