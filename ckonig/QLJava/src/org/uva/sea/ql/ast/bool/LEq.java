package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.AcceptsMathOperands;
import org.uva.sea.ql.ast.interfaces.ReturnsBoolOperands;

public class LEq extends BinaryExpr implements AcceptsMathOperands,
		ReturnsBoolOperands {
	public static final String STR = "<=";

	public LEq(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public final String toString() {
		return STR;
	}
}
