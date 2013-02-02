package org.uva.sea.ql.ast.expressions.binary.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.expressions.binary.BinaryNumericExpr;

public class Div extends BinaryNumericExpr {
	public Div(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}