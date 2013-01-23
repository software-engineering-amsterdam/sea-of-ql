package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.AcceptsMathOperands;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsMathOperands;
import org.uva.sea.ql.ast.UnaryExpr;

public class Neg extends UnaryExpr implements AcceptsMathOperands,
		ReturnsMathOperands {
	public static final String str = "-";

	public Neg(Expr ex) {
		super(ex);
	}

	@Override
	public String toString() {
		return str;
	}
}
