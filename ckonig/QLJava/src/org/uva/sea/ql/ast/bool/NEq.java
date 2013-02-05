package org.uva.sea.ql.ast.bool;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.interfaces.AcceptsBothOperands;

public class NEq extends BinaryBooleanOperator implements AcceptsBothOperands {
	public static final String STR = "!=";

	public NEq(Expr left, Expr right) {
		super(left, right);
	}

	@Override
	public final String toString() {
		return STR;
	}

}
