package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.BinaryExpr;
import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.AcceptsBoolOperands;
import org.uva.sea.ql.ast.interfaces.ReturnsBoolOperands;

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
