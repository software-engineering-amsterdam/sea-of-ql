package org.uva.sea.ql.ast.expressions.binaryExpr;

import org.uva.sea.ql.ast.expressions.Expr;

public class Or extends BinaryExpr {

	public Or(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}