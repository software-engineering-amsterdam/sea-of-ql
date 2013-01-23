package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.AcceptsBoolOperands;
import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsBoolOperands;

public class And extends BinaryExpr implements AcceptsBoolOperands,
		ReturnsBoolOperands {
	public static final String str = "&&";

	public And(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public String toString() {
		return str;
	}
}
