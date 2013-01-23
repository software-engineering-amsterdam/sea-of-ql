package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.AcceptsMathOperands;
import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsMathOperands;

public class Sub extends BinaryExpr implements AcceptsMathOperands,
		ReturnsMathOperands {
	public static final String str = "-";

	public Sub(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public String toString() {
		return str;
	}
}
