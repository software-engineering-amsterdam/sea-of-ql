package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.AcceptsBoolOperands;

public class Not extends UnaryBooleanOperator implements AcceptsBoolOperands {
	public static final String STR = "!";

	public Not(Expr ex) {
		super(ex);
	}

	@Override
	public final String toString() {
		return STR;
	}
}
