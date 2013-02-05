package org.uva.sea.ql.ast.math;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.AcceptsMathOperands;

public class Div extends BinaryMathOperator implements AcceptsMathOperands {
	public static final String STR = "/";

	public Div(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public final String toString() {
		return STR;
	}
	
	
}
