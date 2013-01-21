package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.Expr;

public class Or extends BinaryBoolOperator{
	public static final String str = "||";

	public Or(Expr left, Expr right) {
		super(left, right);
	}
}
