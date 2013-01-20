package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;

public class Eq extends BinaryExpr{
	public static final String str = "==";

	public Eq(Expr left, Expr right) {
		super(left, right);
	}

}
