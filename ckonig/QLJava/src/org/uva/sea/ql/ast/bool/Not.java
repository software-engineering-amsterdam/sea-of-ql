package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.AcceptsBoolOperands;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.ReturnsBoolOperands;
import org.uva.sea.ql.ast.UnaryExpr;

public class Not extends UnaryExpr implements AcceptsBoolOperands,
		ReturnsBoolOperands {
	public static final String str = "!";

	public Not(Expr ex) {
		super(ex);
	}

	@Override
	public String toString() {
		return str;
	}
}
