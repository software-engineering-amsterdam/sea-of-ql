package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.AcceptsBothOperands;
import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsBoolOperands;

public class Eq extends BinaryExpr implements AcceptsBothOperands,
		ReturnsBoolOperands {
	public static final String str = "==";

	public Eq(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public String toString() {
		return str;
	}

}
