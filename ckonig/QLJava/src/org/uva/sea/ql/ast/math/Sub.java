package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.AcceptsMathOperands;
import org.uva.sea.ql.ast.interfaces.ReturnsMathOperands;

public class Sub extends BinaryExpr implements AcceptsMathOperands,
		ReturnsMathOperands {
	public static final String STR = "-";

	public Sub(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public final String toString() {
		return STR;
	}
}
