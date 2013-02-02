package org.uva.sea.ql.ast.expressions.binary;

import org.uva.sea.ql.ast.Expr;

public class Add extends BinaryNumericExpr {
	public Add(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}