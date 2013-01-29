package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.AcceptsBothOperands;
import org.uva.sea.ql.ast.interfaces.ReturnsBoolOperands;

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
