package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.expressions.UnaryExpr;
import org.uva.sea.ql.ast.interfaces.AcceptsBoolOperands;
import org.uva.sea.ql.ast.interfaces.ReturnsBoolOperands;

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
