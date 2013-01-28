package org.uva.sea.ql.ast.expressions;

import org.uva.sea.ql.ast.Binary;
import org.uva.sea.ql.ast.Expr;

public class NEq extends Binary {
	public NEq(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}
}