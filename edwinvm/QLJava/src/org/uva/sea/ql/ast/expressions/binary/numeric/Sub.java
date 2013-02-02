package org.uva.sea.ql.ast.expressions.binary.numeric;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.expressions.binary.BinaryNumericExpr;

public class Sub extends BinaryNumericExpr {
	public Sub(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}