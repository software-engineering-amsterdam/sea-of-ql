package org.uva.sea.ql.ast.expressions.binary.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.expressions.binary.BinaryNumericExpr;

public class Mul extends BinaryNumericExpr {
	public Mul(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}