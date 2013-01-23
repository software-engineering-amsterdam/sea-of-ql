package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.AcceptsMathOperands;
import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsBoolOperands;

public class LT extends BinaryExpr implements AcceptsMathOperands,
		ReturnsBoolOperands {
	public static final String str = "<";

	public LT(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public String toString() {
		return str;
	}
}
