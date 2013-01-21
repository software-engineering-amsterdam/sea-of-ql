package org.uva.sea.ql.ast.expressions.binaryExpr;

import org.uva.sea.ql.ast.expressions.Expr;

public class NEq extends BinaryExpr {

	public NEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}