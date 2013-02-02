package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

public class Div extends BinaryNumericExpr {
	public Div(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}